package com.mpersand.data.remote.model.notice.response

import com.mpersand.domain.model.notice.response.NoticeFileModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NoticeFile(
    val id: Long,
    val url: String
)

fun NoticeFile.asNoticeFileModel() = NoticeFileModel(
    id = id,
    url = url
)