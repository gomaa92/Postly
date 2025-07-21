package com.innovation.features.postdetails.domain.repository

import com.innovation.features.common.model.Post

interface PostDetailsRepository {

    suspend fun getPostById(
        id: String
    ): Post
}