package com.mpersand.domain.repository

import com.mpersand.domain.model.notice.response.NoticeDetailResponseModel
import com.mpersand.domain.model.notice.response.NoticeResponseModel
import okhttp3.MultipartBody
import okhttp3.RequestBody

interface NoticeRepository {
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

    suspend fun getAllNotice(): List<NoticeResponseModel>

    suspend fun getDetailNotice(id: Long): NoticeDetailResponseModel
}