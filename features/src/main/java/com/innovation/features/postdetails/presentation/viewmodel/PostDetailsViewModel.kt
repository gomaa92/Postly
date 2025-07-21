package com.innovation.features.postdetails.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.innovation.features.postdetails.domain.usecase.GetPostDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(private val getPostDetailsUseCase: GetPostDetailsUseCase) :
    ViewModel() {

    private val _viewState = MutableStateFlow(PostDetailsState())
    val viewState: StateFlow<PostDetailsState> = _viewState

    fun loadPostDetails(postId: String) = viewModelScope.launch {
        _viewState.value = PostDetailsState(post = getPostDetailsUseCase(postId))
    }
}