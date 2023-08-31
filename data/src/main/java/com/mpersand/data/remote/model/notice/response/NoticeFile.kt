package com.mpersand.data.remote.model.notice.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NoticeFile(
    val id: Long,
    val url: String
)
