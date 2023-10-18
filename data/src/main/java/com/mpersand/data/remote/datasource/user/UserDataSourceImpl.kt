package com.mpersand.data.remote.datasource.user

import com.mpersand.data.remote.network.UserApi
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
    private val userApi: UserApi
): UserDataSource {
    override suspend fun getMyReservedCourt(): String = userApi.getMyReservedCourt()
}
