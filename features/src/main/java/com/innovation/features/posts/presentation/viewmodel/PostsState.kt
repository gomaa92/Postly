package com.innovation.features.posts.presentation.viewmodel

import com.innovation.features.posts.domain.model.Post

data class PostsState(
    val isLoading: Boolean = false,
    val posts: List<Post> = emptyList(),
    val error: String? = null,
    val isEndReached: Boolean = false
)
