package com.innovation.features.postdetails.domain.repository

import com.innovation.features.posts.domain.model.Post

interface PostDetailsRepository {

    suspend fun getPostById(
        id: String
    ): Post
}