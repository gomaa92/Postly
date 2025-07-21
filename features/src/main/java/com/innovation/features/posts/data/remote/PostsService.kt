package com.innovation.features.posts.data.remote

import com.innovation.features.BuildConfig
import com.innovation.features.posts.data.remote.model.PostsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PostsService {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("q") category: String = "sport",
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int,
        @Query("pageSize") perPage: Int,
    ): PostsResponse
}
