package com.innovation.navigation

sealed class Destination(val route: String) {
    object PostsList : Destination("posts_list")
    object PostDetails : Destination("post_details/{postId}") {
        fun createRoute(postId: String) = "post_details/$postId"
    }
}
