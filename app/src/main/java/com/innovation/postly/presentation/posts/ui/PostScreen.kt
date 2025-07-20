package com.innovation.postly.presentation.posts.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.innovation.postly.presentation.posts.viewmodel.PostsViewModel


@Composable
fun HomeScreen(
    viewModel: PostsViewModel,
    modifier: Modifier = Modifier,
    //navigateToDetails: (Int) -> Unit,
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()

    PostsListContent(
        state = state,
        onLoadMore = {
            viewModel.loadPosts()
                     },
        onRetry = { viewModel.retry() },
        onRefresh = { viewModel.refresh() },
        modifier = modifier
    )
}
