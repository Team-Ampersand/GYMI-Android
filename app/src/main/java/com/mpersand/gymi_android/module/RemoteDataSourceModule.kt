package com.mpersand.gymi_android.module

import com.mpersand.data.remote.datasource.AuthDataSource
import com.mpersand.data.remote.datasource.AuthDataSourceImpl
import com.mpersand.data.remote.datasource.declaration.DeclarationDataSource
import com.mpersand.data.remote.datasource.declaration.DeclarationDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RemoteDataSourceModule {
    @Binds
    fun bindsAuthDataSource(authDataSourceImpl: AuthDataSourceImpl): AuthDataSource

    @Binds
    fun bindsDeclarationDataSource(declarationDataSourceImpl: DeclarationDataSourceImpl): DeclarationDataSource
}