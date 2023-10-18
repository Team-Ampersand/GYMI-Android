package com.mpersand.data.remote.datasource.user

interface UserDataSource {
    suspend fun getMyReservedCourt(): String
}
