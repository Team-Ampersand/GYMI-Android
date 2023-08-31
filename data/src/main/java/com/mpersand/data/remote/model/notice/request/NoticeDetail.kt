package com.mpersand.data.remote.model.notice.request

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NoticeDetail(
    val title: String,
    val content: String
)
