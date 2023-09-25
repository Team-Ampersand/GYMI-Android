package com.mpersand.gymi_android.module

import com.mpersand.data.remote.datasource.auth.AuthDataSource
import com.mpersand.data.remote.datasource.auth.AuthDataSourceImpl
import com.mpersand.data.remote.datasource.court.CourtDataSource
import com.mpersand.data.remote.datasource.court.CourtDataSourceImpl
import com.mpersand.data.remote.datasource.declaration.DeclarationDataSource
import com.mpersand.data.remote.datasource.declaration.DeclarationDataSourceImpl
import com.mpersand.data.remote.datasource.notice.NoticeDataSource
import com.mpersand.data.remote.datasource.notice.NoticeDataSourceImpl
import com.mpersand.data.remote.datasource.reservation.ReservationDataSource
import com.mpersand.data.remote.datasource.reservation.ReservationDataSourceImpl
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

    @Binds
    fun bindsCourtDataSource(courtDataSourceImpl: CourtDataSourceImpl): CourtDataSource

    @Binds
    fun bindsReservationDataSource(reservationDataSourceImpl: ReservationDataSourceImpl): ReservationDataSource
}
