package com.mpersand.data.network.notice

import com.mpersand.data.remote.model.notice.response.NoticeDetailResponse
import com.mpersand.data.remote.model.notice.response.NoticeResponse
import com.mpersand.data.remote.network.NoticeApi
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okio.Buffer
import java.time.LocalDateTime


class FakeNoticeApi(
    private var noticesResponses: List<NoticeResponse>,
    private val noticeDetailResponses: NoticeDetailResponse,
): NoticeApi {
    override suspend fun createNotice(
        notice: HashMap<String, RequestBody>,
        file: MultipartBody.Part
    ) {
        noticesResponses = noticesResponses.plus(
            NoticeResponse(
                id = noticesResponses.size.toLong() + 1,
                title = notice["title"]!!.requestBodyToString(),
                content =  notice["content"]!!.requestBodyToString(),
                role = "",
                createdDate = LocalDateTime.now(),
            )
        )
    }

    override suspend fun deleteNotice(id: Long) {
        noticesResponses = noticesResponses.filterNot { it.id == id }
    }

    override suspend fun modifyNotice(
        id: Long,
        notice: HashMap<String, RequestBody>,
        file: MultipartBody.Part
    ) {
        noticesResponses = noticesResponses.filterNot { it.id == id }
        noticesResponses = noticesResponses.plus(
            NoticeResponse(
                id = noticesResponses.size.toLong() + 1,
                title = notice["title"]!!.requestBodyToString(),
                content = notice["content"]!!.requestBodyToString(),
                role = "",
                createdDate = LocalDateTime.now(),
            )
        )
    }

    override suspend fun getAllNotice(): List<NoticeResponse> = noticesResponses

    override suspend fun getDetailNotice(id: Long): NoticeDetailResponse = noticeDetailResponses
}

private fun RequestBody.requestBodyToString(): String {
    val buffer = Buffer()
    this.writeTo(buffer)
    return buffer.readUtf8()
}
