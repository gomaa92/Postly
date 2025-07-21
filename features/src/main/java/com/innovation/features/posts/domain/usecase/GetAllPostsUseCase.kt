package com.innovation.features.posts.domain.usecase

import com.innovation.features.posts.domain.model.Post
import com.innovation.features.posts.domain.repository.PostsRepository
import javax.inject.Inject

class GetAllPostsUseCase @Inject constructor(
    private val postsRepository: PostsRepository
) {
    suspend operator fun invoke(
        page: Int,
        pageSize: Int
    ): List<Post> =
        postsRepository.getTopHeadlines(page = page, pageSize = pageSize)
}
