package com.mpersand.data.remote.datasource.notice

import com.mpersand.data.remote.model.notice.response.NoticeDetailResponse
import com.mpersand.data.remote.model.notice.response.NoticeResponse
import com.mpersand.data.remote.network.NoticeApi
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class NoticeDataSourceImpl @Inject constructor(
    private val noticeApi: NoticeApi
): NoticeDataSource {
    override suspend fun createNotice(
        notice: HashMap<String, RequestBody>,
        file: MultipartBody.Part
    ) = noticeApi.createNotice(
        notice = notice,
        file = file
    )

    override suspend fun deleteNotice(id: Long) = noticeApi.deleteNotice(id)

    override suspend fun modifyNotice(
        id: Long,
        notice: HashMap<String, RequestBody>,
        file: MultipartBody.Part
    ) = noticeApi.modifyNotice(
        id = id,
        notice = notice,
        file = file
    )

    override suspend fun getAllNotice(): List<NoticeResponse> = noticeApi.getAllNotice()

    override suspend fun getDetailNotice(id: Long): NoticeDetailResponse = noticeApi.getDetailNotice(id)
}