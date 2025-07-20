package com.innovation.postly.di

import com.innovation.postly.common.networkmanager.InternetManager
import com.innovation.postly.common.networkmanager.InternetManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface InternetManagerModule {

    @Binds
    fun bindInternetManager(internetManagerImpl: InternetManagerImpl): InternetManager
}