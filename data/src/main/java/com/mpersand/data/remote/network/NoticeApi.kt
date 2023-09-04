package com.mpersand.data.remote.network

import com.mpersand.data.remote.model.notice.response.NoticeDetailResponse
import com.mpersand.data.remote.model.notice.response.NoticeResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap
import retrofit2.http.Path

interface NoticeApi {
    @Multipart
    @POST("notice")
    suspend fun createNotice(
        @PartMap notice: HashMap<String, RequestBody>,
        @Part("file") file: MultipartBody.Part
    )

    @DELETE("notice/{id}")
    suspend fun deleteNotice(
        @Path("id") id: Long
    )

    @Multipart
    @PATCH("notice/{id}")
    suspend fun modifyNotice(
        @Path("id") id: Long,
        @PartMap notice: HashMap<String, RequestBody>,
        @Part("file") file: MultipartBody.Part
    )

    @GET("notice")
    suspend fun getAllNotice(): List<NoticeResponse>

    @GET("notice/{id}")
    suspend fun getDetailNotice(
        @Path("id") id: Long
    ): NoticeDetailResponse
}