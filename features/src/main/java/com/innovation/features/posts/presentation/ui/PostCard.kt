package com.innovation.features.posts.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import com.innovation.designsystem.components.ImageLoadingError
import com.innovation.designsystem.components.LoadingItem
import com.innovation.designsystem.theme.LocalSpacing
import com.innovation.features.common.model.Post

@Composable
fun PostCard(post: Post, onPostClick: (String) -> Unit) {
    val spacing = LocalSpacing.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clickable { onPostClick(post.id) },
        shape = RoundedCornerShape(spacing.s),
        elevation = CardDefaults.cardElevation(spacing.xxs)
    ) {
        Box {
            SubcomposeAsyncImage(
                model = post.imageURL,
                contentDescription = post.title,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop,
                loading = { LoadingItem() },
                error = { ImageLoadingError() }
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.75f)
                            ),
                            startY = 300f
                        )
                    )
            )
            Text(
                text = post.title,
                style = MaterialTheme.typography.titleMedium.copy(color = Color.White),
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(spacing.m),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
