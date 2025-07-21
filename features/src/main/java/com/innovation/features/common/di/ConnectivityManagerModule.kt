package com.innovation.features.common.di

import com.innovation.utils.networkmanager.IConnectivityManager
import com.innovation.utils.networkmanager.IConnectivityManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ConnectivityManagerModule {

    @Binds
    fun bindConnectivityManager(connectivityManager: IConnectivityManagerImpl): IConnectivityManager
}