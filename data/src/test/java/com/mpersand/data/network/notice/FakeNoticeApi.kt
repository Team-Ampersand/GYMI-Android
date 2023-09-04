package com.mpersand.data.network.notice

import com.mpersand.data.remote.model.notice.response.NoticeDetailResponse
import com.mpersand.data.remote.model.notice.response.NoticeResponse
import com.mpersand.data.remote.network.NoticeApi
import okhttp3.MultipartBody
import okhttp3.RequestBody

class FakeNoticeApi(
    private var noticesResponses: NoticeResponse,
    private var noticeDetailResponse: NoticeDetailResponse,
    private var noticeDetailResponses: MutableList<NoticeDetailResponse>,
): NoticeApi {
    override suspend fun createNotice(
        notice: HashMap<String, RequestBody>,
        file: MultipartBody.Part
    ) {
        noticeDetailResponses.add(
            NoticeDetailResponse(
                id = noticeDetailResponses.size.toLong(),
                title = noticeDetailResponse.title,
                content = noticeDetailResponse.content,
                role = noticeDetailResponse.role,
                noticeFile = noticeDetailResponse.noticeFile,
                createdDate = noticeDetailResponse.createdDate
            )
        )
    }

    override suspend fun deleteNotice(id: Long) {
        noticeDetailResponses.removeIf { it.id == id }
    }

    override suspend fun modifyNotice(
        id: Long,
        notice: HashMap<String, RequestBody>,
        file: MultipartBody.Part
    ) {
        noticeDetailResponses.drop(id.toInt())
        noticeDetailResponses.add(
            NoticeDetailResponse(
                id = noticeDetailResponses.size.toLong(),
                title = noticeDetailResponse.title,
                content = noticeDetailResponse.content,
                role = noticeDetailResponse.role,
                noticeFile = noticeDetailResponse.noticeFile,
                createdDate = noticeDetailResponse.createdDate
            )
        )
    }

    override suspend fun getAllNotice(): NoticeResponse = noticesResponses

    override suspend fun getDetailNotice(id: Long): NoticeDetailResponse = noticeDetailResponses.single { it.id == id }
}
