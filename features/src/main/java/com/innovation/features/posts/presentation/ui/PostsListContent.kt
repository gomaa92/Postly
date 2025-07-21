package com.innovation.features.posts.presentation.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.innovation.designsystem.components.EmptyScreenWithRetry
import com.innovation.designsystem.components.EndReachedMessage
import com.innovation.designsystem.components.ErrorFullScreen
import com.innovation.designsystem.components.LoadingItem
import com.innovation.designsystem.components.PullToRefreshIndicator
import com.innovation.designsystem.components.RetrySection
import com.innovation.designsystem.theme.LocalSpacing
import com.innovation.features.posts.presentation.viewmodel.PostsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostsListContent(
    state: PostsState,
    onLoadMore: () -> Unit,
    onRetry: () -> Unit,
    onRefresh: () -> Unit,
    onPostClick: (String) -> Unit,
    modifier: Modifier
) {
    val spacing = LocalSpacing.current
    val lazyListState = rememberLazyListState()
    val isRefreshing = state.isLoading && state.posts.isEmpty()
    val pullToRefreshState = rememberPullToRefreshState()

    val shouldLoadMore = remember {
        derivedStateOf {
            val visibleItems = lazyListState.layoutInfo.visibleItemsInfo
            val totalItemsCount = lazyListState.layoutInfo.totalItemsCount
            if (totalItemsCount == 0) return@derivedStateOf false
            val lastVisibleItemIndex = visibleItems.lastOrNull()?.index ?: -1
            lastVisibleItemIndex >= totalItemsCount - 1
        }
    }

    LaunchedEffect(lazyListState, state.isLoading, state.isEndReached) {
        snapshotFlow { shouldLoadMore.value }
            .collect { trigger ->
                if (trigger && !state.isLoading && !state.isEndReached && state.error == null) {
                    onLoadMore()
                }
            }
    }

    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
        modifier = modifier,
        state = pullToRefreshState,
        indicator = {
            if (state.isEmpty.not())
                PullToRefreshIndicator(
                    state = pullToRefreshState,
                    isRefreshing = isRefreshing,
                    modifier = Modifier.align(Alignment.TopCenter)
                )
        }
    ) {
        LazyColumn(
            state = lazyListState,
            contentPadding = PaddingValues(spacing.m),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(state.posts) { post ->
                PostCard(
                    post = post,
                    onPostClick = onPostClick,
                )
                Spacer(modifier = Modifier.height(spacing.xs))
            }
            item {
                when {
                    state.isLoading && state.posts.isNotEmpty() -> LoadingItem()
                    state.error != null && state.posts.isNotEmpty() -> RetrySection(onRetry)
                    state.isEndReached -> EndReachedMessage()
                    state.isEmpty -> EmptyScreenWithRetry(
                        onRetry
                    )
                }
            }
        }
    }

    if (state.error != null && state.posts.isEmpty()) {
        ErrorFullScreen(onRetry)
    }
}

