package com.innovation.postly.presentation.posts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.innovation.postly.common.networkmanager.InternetManager
import com.innovation.postly.domain.usecase.GetAllPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val pageSize = 15

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetAllPostsUseCase,
    private val internetManager: InternetManager
) : ViewModel() {
    private val _viewState = MutableStateFlow(PostsState())
    val viewState: StateFlow<PostsState> = _viewState

    private var currentPage = 1
    private var isLoading = false

    init {
        loadPosts()
    }

    fun loadPosts() {
        if (isLoading || _viewState.value.isEndReached) return

        isLoading = true
        _viewState.update { it.copy(isLoading = true, error = null) }

        viewModelScope.launch {
            try {
                val posts = getPostsUseCase.invoke(page = currentPage, pageSize = pageSize)
                val newList = _viewState.value.posts + posts
                _viewState.update {
                    it.copy(
                        posts = newList,
                        isLoading = false,
                        isEndReached = posts.size < pageSize || internetManager.isNetworkAvailable().not()
                    )
                }
                currentPage++
            } catch (e: Exception) {
                _viewState.update { it.copy(isLoading = false, error = e.message) }
            }
            isLoading = false
        }
    }

    fun retry() {
        loadPosts()
    }

    fun refresh() {
        currentPage = 1
        _viewState.update { PostsState() }
        loadPosts()
    }
}
