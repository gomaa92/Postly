package com.innovation.postly.presentation.posts.viewmodel

import com.innovation.postly.domain.model.Post

data class PostsState(
    val isLoading: Boolean = false,
    val posts: List<Post> = emptyList(),
    val error: String? = null,
    val isEndReached: Boolean = false
)
