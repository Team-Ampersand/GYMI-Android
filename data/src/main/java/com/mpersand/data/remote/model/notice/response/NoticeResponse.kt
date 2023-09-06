package com.mpersand.data.remote.model.notice.response

import com.mpersand.domain.model.notice.response.NoticeResponseModel
import com.squareup.moshi.JsonClass
import java.time.LocalDateTime

@JsonClass(generateAdapter = true)
data class NoticeResponse(
    val id: Long,
    val title: String,
    val content: String,
    val role: String,
    val createdDate: LocalDateTime
)

fun NoticeResponse.asNoticeResponseModel() = NoticeResponseModel(
    id = id,
    title = title,
    content = content,
    role = role,
    createdDate = createdDate
)