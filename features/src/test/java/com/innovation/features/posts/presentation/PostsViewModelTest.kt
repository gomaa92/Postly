package com.innovation.features.posts.presentation

import app.cash.turbine.test
import com.innovation.features.posts.MainDispatcherRule
import com.innovation.features.posts.domain.usecase.GetAllPostsUseCase
import com.innovation.features.posts.presentation.viewmodel.PostsViewModel
import com.innovation.utils.networkmanager.IConnectivityManager
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class PostsViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val getPostsUseCase: GetAllPostsUseCase = mockk()
    private val connectivityManager: IConnectivityManager = mockk()

    private lateinit var viewModel: PostsViewModel

    @Before
    fun setup() {
        every { connectivityManager.isNetworkAvailable() } returns true
        viewModel = PostsViewModel(getPostsUseCase, connectivityManager)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadPosts should set isEndReached when less than pageSize`() = runTest {
        coEvery { getPostsUseCase.invoke(1, 10) } returns emptyList()

        viewModel.viewState.test {
            awaitItem() // Initial state

            viewModel.loadPosts()

            awaitItem() // Loading
            val loadedState = awaitItem()

            assertTrue(loadedState.isEmpty)
            assertTrue(loadedState.posts.isEmpty())
        }
    }

    @Test
    fun `loadPosts should handle exception and set error`() = runTest {
        coEvery { getPostsUseCase.invoke(1, 10) } throws RuntimeException("Network error")

        viewModel.viewState.test {
            awaitItem() // Initial state

            viewModel.loadPosts()

            awaitItem() // Loading
            val errorState = awaitItem()

            assertFalse(errorState.isLoading)
            assertEquals("Network error", errorState.error)
        }
    }
}
