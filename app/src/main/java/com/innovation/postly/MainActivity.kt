package com.innovation.postly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.innovation.postly.presentation.posts.ui.HomeScreen
import com.innovation.postly.presentation.posts.viewmodel.PostsViewModel
import com.innovation.postly.ui.theme.PostlyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val postsViewModel by viewModels<PostsViewModel>()
        enableEdgeToEdge()
        setContent {
            PostlyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(viewModel = postsViewModel, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
