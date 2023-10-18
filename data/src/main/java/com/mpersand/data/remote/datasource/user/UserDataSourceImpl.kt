package com.mpersand.data.remote.datasource.user

import com.mpersand.data.remote.network.UserApi
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
    private val userApi: UserApi
): UserDataSource {
    override fun getMyReservedCourt(): String = userApi.getMyReservedCourt()
}
