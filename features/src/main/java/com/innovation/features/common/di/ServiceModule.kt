package com.innovation.features.common.di

import com.innovation.features.posts.data.remote.PostsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    /**
     * Provides the [PostsService] instance for making network requests.
     *
     * @param retrofit The Retrofit instance configured with the base URL and converters.
     * @return An instance of [PostsService].
     */
    @Provides
    @Singleton
    fun providePostsService(retrofit: Retrofit): PostsService {
        return retrofit.create(PostsService::class.java)
    }
}