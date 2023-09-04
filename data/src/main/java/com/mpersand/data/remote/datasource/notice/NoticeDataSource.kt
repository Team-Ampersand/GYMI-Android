package com.mpersand.data.remote.datasource.notice

import com.mpersand.data.remote.model.notice.response.NoticeDetailResponse
import com.mpersand.data.remote.model.notice.response.NoticeResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody

interface NoticeDataSource {
    suspend fun createNotice(
        notice: HashMap<String, RequestBody>,
        file: MultipartBody.Part
    )

    suspend fun deleteNotice(id: Long)

    suspend fun modifyNotice(
        id: Long,
        notice: HashMap<String, RequestBody>,
        file: MultipartBody.Part
    )

    suspend fun getAllNotice(): List<NoticeResponse>

    suspend fun getDetailNotice(id: Long): NoticeDetailResponse
}