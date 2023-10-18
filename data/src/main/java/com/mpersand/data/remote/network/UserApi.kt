package com.mpersand.data.remote.network

import retrofit2.http.GET

interface UserApi {
    @GET("user")
    fun getMyReservedCourt(): String
}
