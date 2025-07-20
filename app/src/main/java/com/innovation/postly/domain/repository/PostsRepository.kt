package com.innovation.postly.domain.repository

import com.innovation.postly.domain.model.Post

interface PostsRepository {
    suspend fun getTopHeadlines(
        page: Int,
        pageSize: Int
    ): List<Post>

    suspend fun getPostById(
        id: Int
    ): Post
}
