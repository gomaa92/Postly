package com.innovation.postly.di

import com.innovation.postly.data.repository.PostsRepositoryImpl
import com.innovation.postly.domain.repository.PostsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindPostRepository(postsRepositoryImpl: PostsRepositoryImpl): PostsRepository
}
