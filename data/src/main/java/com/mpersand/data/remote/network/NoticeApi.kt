package com.mpersand.data.remote.network

import com.mpersand.data.remote.model.notice.request.NoticeRequest
import com.mpersand.data.remote.model.notice.response.NoticeDetailResponse
import com.mpersand.data.remote.model.notice.response.NoticeResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface NoticeApi {
    @Multipart
    @POST("notice")
    suspend fun createNotice(
        @Body noticeRequest: NoticeRequest
    )

    @DELETE("notice/{id}")
    suspend fun deleteNotice(
        @Path("id") id: Long
    )

    @Multipart
    @PATCH("notice/{id}")
    suspend fun modifyNotice(
        @Path("id") id: Long,
        @Body noticeRequest: NoticeRequest
    )

    @GET("notice")
    suspend fun getAllNotice(): NoticeResponse

    @GET("notice/{id}")
    suspend fun getDetailNotice(
        @Path("id") id: Long
    ): NoticeDetailResponse
}