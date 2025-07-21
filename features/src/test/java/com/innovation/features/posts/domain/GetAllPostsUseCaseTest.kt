package com.innovation.features.posts.domain

import com.innovation.features.common.model.Post
import com.innovation.features.posts.domain.repository.PostsRepository
import com.innovation.features.posts.domain.usecase.GetAllPostsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetAllPostsUseCaseTest {

    private val repository: PostsRepository = mockk()
    private lateinit var useCase: GetAllPostsUseCase

    @Before
    fun setup() {
        useCase = GetAllPostsUseCase(repository)
    }

    @Test
    fun `should return posts from repository`() = runBlocking {
        // Given
        val post = Post("1", "Title", "Desc", "url")
        coEvery { repository.getTopHeadlines(1, 10) } returns listOf(post)

        // When
        val result = useCase(1, 10)

        // Then
        assertEquals(1, result.size)
        assertEquals(post, result.first())
    }
}

