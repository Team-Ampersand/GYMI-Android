package com.mpersand.gymi_android.module

import com.mpersand.data.remote.datasource.auth.AuthDataSource
import com.mpersand.data.remote.datasource.auth.AuthDataSourceImpl
import com.mpersand.data.remote.datasource.declaration.DeclarationDataSource
import com.mpersand.data.remote.datasource.declaration.DeclarationDataSourceImpl
import com.mpersand.data.remote.datasource.notice.NoticeDataSource
import com.mpersand.data.remote.datasource.notice.NoticeDataSourceImpl
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

    @Binds
    fun bindsNoticeDataSource(noticeDataSourceImpl: NoticeDataSourceImpl): NoticeDataSource
}