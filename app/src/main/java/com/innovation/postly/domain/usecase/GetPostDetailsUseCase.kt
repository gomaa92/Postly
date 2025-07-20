package com.innovation.postly.domain.usecase

import com.innovation.postly.domain.model.Post
import com.innovation.postly.domain.repository.PostsRepository
import javax.inject.Inject

class GetPostDetailsUseCase @Inject constructor(
    private val postsRepository: PostsRepository
) {
    suspend operator fun invoke(id: Int): Post {
        return postsRepository.getPostById(id)
    }
}
