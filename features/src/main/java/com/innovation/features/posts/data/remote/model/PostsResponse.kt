package com.innovation.features.posts.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostsResponse(
    @Json(name = "articles")
    val posts: List<PostDto>?
)

@JsonClass(generateAdapter = true)
data class PostDto(
    val title: String?,
    val urlToImage: String?,
    val description: String?
)
