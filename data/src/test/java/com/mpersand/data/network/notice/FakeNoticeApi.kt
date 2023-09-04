package com.mpersand.data.network.notice

import com.mpersand.data.remote.model.notice.response.NoticeDetailResponse
import com.mpersand.data.remote.model.notice.response.NoticeList
import com.mpersand.data.remote.model.notice.response.NoticeResponse
import com.mpersand.data.remote.network.NoticeApi
import okhttp3.MultipartBody
import okhttp3.RequestBody

class FakeNoticeApi(
    private var noticesResponses: NoticeResponse,
    private var noticeDetailResponses: List<NoticeDetailResponse>,
): NoticeApi {
    override suspend fun createNotice(
        notice: HashMap<String, RequestBody>,
        file: MultipartBody.Part
    ) {
        noticesResponses.body.add(
            NoticeList(
                id = noticesResponses.body.size.toLong(),
                title = noticesResponses.body[0].title,
                content = noticesResponses.body[0].content,
                role = noticesResponses.body[0].role,
                createdDate = noticesResponses.body[0].createdDate,
            )
        )
    }

    override suspend fun deleteNotice(id: Long) {
        noticesResponses.body.removeIf { it.id == id }
    }

    override suspend fun modifyNotice(
        id: Long,
        notice: HashMap<String, RequestBody>,
        file: MultipartBody.Part
    ) {
        noticesResponses.body.drop(id.toInt())
        noticesResponses.body.add(
            id.toInt(),
            NoticeList(
                id = id,
                title = noticesResponses.body[id.toInt()].title,
                content = noticesResponses.body[id.toInt()].content,
                role = noticesResponses.body[id.toInt()].role,
                createdDate = noticesResponses.body[id.toInt()].createdDate,
            )
        )
    }

    override suspend fun getAllNotice(): NoticeResponse = noticesResponses

    override suspend fun getDetailNotice(id: Long): NoticeDetailResponse = noticeDetailResponses.single { it.id == id }
}
