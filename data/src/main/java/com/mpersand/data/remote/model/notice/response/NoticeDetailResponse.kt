package com.mpersand.data.remote.model.notice.response

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
