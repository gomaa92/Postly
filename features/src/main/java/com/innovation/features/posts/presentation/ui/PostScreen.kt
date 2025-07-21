package com.innovation.features.posts.presentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.innovation.features.posts.presentation.viewmodel.PostsViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostListScreen(
    viewModel: PostsViewModel = hiltViewModel(),
    onPostClick: (String) -> Unit,
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Posts") },
            )
        },
    ) { paddingValues ->
        PostsListContent(
            state = state,
            onLoadMore = {
                viewModel.loadPosts()
            },
            onRetry = { viewModel.retry() },
            onRefresh = { viewModel.refresh() },
            onPostClick = onPostClick,
            modifier = Modifier.padding(paddingValues)
        )
    }
}
