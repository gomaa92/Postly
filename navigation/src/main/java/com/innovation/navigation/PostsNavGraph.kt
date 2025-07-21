package com.innovation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.innovation.features.postdetails.presentation.ui.PostDetailsScreen
import com.innovation.features.posts.presentation.ui.PostListScreen

@Composable
fun PostsNavGraph(
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destination.PostsList.route
    ) {
        composable(Destination.PostsList.route) {
            PostListScreen(
                onPostClick = { postId ->
                    navController.navigate(Destination.PostDetails.createRoute(postId))
                }
            )
        }

        composable(
            route = Destination.PostDetails.route,
            arguments = listOf(navArgument("postId") { type = NavType.StringType })
        ) { backStackEntry ->
            val postId = backStackEntry.arguments?.getString("postId") ?: return@composable

            PostDetailsScreen(
                postId = postId,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}