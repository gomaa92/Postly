package com.innovation.features.posts.data

import com.innovation.features.common.db.entitiy.PostsEntity
import com.innovation.features.posts.MainDispatcherRule
import com.innovation.features.posts.data.local.PostsDao
import com.innovation.features.posts.data.remote.PostsService
import com.innovation.features.posts.data.remote.model.PostDto
import com.innovation.features.posts.data.remote.model.PostsResponse
import com.innovation.features.posts.data.repository.PostsRepositoryImpl
import com.innovation.utils.networkmanager.IConnectivityManager
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class PostsRepositoryImplTest {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private val api: PostsService = mockk()
    private val postsDao: PostsDao = mockk(relaxed = true)
    private val connectivityManager: IConnectivityManager = mockk()

    private lateinit var repository: PostsRepositoryImpl

    @Before
    fun setup() {
        repository = PostsRepositoryImpl(api, postsDao, connectivityManager)
    }

    @Test
    fun `should fetch from api when network is available`() = runTest {
        coEvery { connectivityManager.isNetworkAvailable() } returns true
        val postDto = PostDto("title", "url", "desc")
        val postsResponse = PostsResponse(listOf(postDto))
        coEvery { api.getTopHeadlines(any(), any(), any(), any()) } returns postsResponse

        val result = repository.getTopHeadlines(1, 10)

        coVerify { postsDao.insertOrUpdatePosts(any()) }
        Assert.assertEquals(1, result.size)
        Assert.assertEquals("title", result.first().title)
    }

    @Test
    fun `should fetch from database when network is not available`() = runTest {
        coEvery { connectivityManager.isNetworkAvailable() } returns false
        val entity = PostsEntity("id", "title", "desc", "url")
        coEvery { postsDao.getAllPosts() } returns listOf(entity)

        val result = repository.getTopHeadlines(1, 10)

        coVerify(exactly = 0) { api.getTopHeadlines(any(), any(), any(), any()) }
        Assert.assertEquals(1, result.size)
        Assert.assertEquals("title", result.first().title)
    }

    @Test
    fun `should not insert into db when api returns empty list`() = runTest {
        coEvery { connectivityManager.isNetworkAvailable() } returns true
        coEvery {
            api.getTopHeadlines(
                any(),
                any(),
                any(),
                any()
            )
        } returns PostsResponse(emptyList())

        val result = repository.getTopHeadlines(1, 10)

        coVerify(exactly = 0) { postsDao.insertOrUpdatePosts(any()) }
        Assert.assertTrue(result.isEmpty())
    }
}