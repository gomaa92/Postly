package com.innovation.features.posts.domain.repository

import com.innovation.features.common.model.Post

interface PostsRepository {
    suspend fun getTopHeadlines(
        page: Int,
        pageSize: Int
    ): List<Post>
}
