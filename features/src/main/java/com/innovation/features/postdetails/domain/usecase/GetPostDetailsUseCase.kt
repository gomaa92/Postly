package com.innovation.features.postdetails.domain.usecase

import com.innovation.features.postdetails.domain.repository.PostDetailsRepository
import com.innovation.features.common.model.Post
import javax.inject.Inject

class GetPostDetailsUseCase @Inject constructor(
    private val postDetailsRepository: PostDetailsRepository
) {
    suspend operator fun invoke(id: String): Post {
        return postDetailsRepository.getPostById(id)
    }
}