package com.mpersand.data.remote.model.notice.request

import com.squareup.moshi.JsonClass
import okhttp3.MultipartBody

@JsonClass(generateAdapter = true)
data class NoticeBody(
    val notice: NoticeDetail,
    val file: MultipartBody.Part
)
