package com.mpersand.gymi_android.module

import com.mpersand.data.local.datasource.LocalDataSource
import com.mpersand.data.local.datasource.LocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface LocalDataSourceModule {
    @Binds
    fun bindsLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource
}