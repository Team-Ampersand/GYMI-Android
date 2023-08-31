package com.mpersand.gymi_android.module

import com.mpersand.data.repository.AuthRepositoryImpl
import com.mpersand.data.repository.DeclarationRepositoryImpl
import com.mpersand.domain.repository.AuthRepository
import com.mpersand.domain.repository.DeclarationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindsAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    @Binds
    fun bindsDeclarationRepository(declarationRepositoryImpl: DeclarationRepositoryImpl): DeclarationRepository
}