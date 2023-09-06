package com.mpersand.domain.repository

import com.mpersand.domain.model.notice.response.NoticeDetailResponseModel
import com.mpersand.domain.model.notice.response.NoticeResponseModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okio.Buffer
import java.time.LocalDateTime

class FakeNoticeRepository(
    private var noticesResponses: List<NoticeResponseModel>,
    private val noticeDetailResponses: NoticeDetailResponseModel,
): NoticeRepository {
    override suspend fun createNotice(
        notice: HashMap<String, RequestBody>,
        file: MultipartBody.Part
    ) {
        noticesResponses = noticesResponses.plus(
            NoticeResponseModel(
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
            NoticeResponseModel(
                id = noticesResponses.size.toLong() + 1,
                title = notice["title"]!!.requestBodyToString(),
                content = notice["content"]!!.requestBodyToString(),
                role = "",
                createdDate = LocalDateTime.now(),
            )
        )
    }

    override suspend fun getAllNotice(): List<NoticeResponseModel> = noticesResponses

    override suspend fun getDetailNotice(id: Long): NoticeDetailResponseModel = noticeDetailResponses
}

private fun RequestBody.requestBodyToString(): String {
    val buffer = Buffer()
    this.writeTo(buffer)
    return buffer.readUtf8()
}