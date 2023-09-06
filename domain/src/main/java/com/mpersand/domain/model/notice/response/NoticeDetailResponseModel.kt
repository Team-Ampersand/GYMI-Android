package com.mpersand.domain.model.notice.response

import java.time.LocalDateTime

data class NoticeDetailResponseModel(
    val id: Long,
    val title: String,
    val content: String,
    val role: String,
    val noticeFile: List<NoticeFileModel>,
    val createdDate: LocalDateTime
)