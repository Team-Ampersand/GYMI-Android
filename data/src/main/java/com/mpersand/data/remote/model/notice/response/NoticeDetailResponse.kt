package com.mpersand.data.remote.model.notice.response

import com.mpersand.domain.model.notice.response.NoticeDetailResponseModel
import com.squareup.moshi.JsonClass
import java.time.LocalDateTime

@JsonClass(generateAdapter = true)
data class NoticeDetailResponse(
    val id: Long,
    val title: String,
    val content: String,
    val role: String,
    val noticeFile: List<NoticeFile>,
    val createdDate: LocalDateTime
)

fun NoticeDetailResponse.asNoticeDetailResponseModel() = NoticeDetailResponseModel(
    id = id,
    title = title,
    content = content,
    role = role,
    noticeFile = noticeFile.map { it.asNoticeFileModel() },
    createdDate = createdDate
)