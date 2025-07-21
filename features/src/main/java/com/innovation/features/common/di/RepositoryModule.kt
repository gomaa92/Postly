package com.innovation.features.common.di

import com.innovation.features.postdetails.data.repository.PostDetailsRepositoryImpl
import com.innovation.features.postdetails.domain.repository.PostDetailsRepository
import com.innovation.features.posts.data.repository.PostsRepositoryImpl
import com.innovation.features.posts.domain.repository.PostsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindPostsRepository(postsRepositoryImpl: PostsRepositoryImpl): PostsRepository

    @Binds
    fun bindPostDetailsRepository(postDetailsRepositoryImpl: PostDetailsRepositoryImpl): PostDetailsRepository
}
