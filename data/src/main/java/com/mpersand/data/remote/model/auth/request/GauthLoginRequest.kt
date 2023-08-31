package com.mpersand.data.remote.model.auth.request

import com.mpersand.domain.model.auth.request.GauthLoginRequestModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GauthLoginRequest(
    val code: String,
    val deviceToken: String?
)

fun GauthLoginRequestModel.asGauthLoginRequest() = GauthLoginRequest(
    code = code,
    deviceToken = deviceToken
)