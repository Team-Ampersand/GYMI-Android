package com.mpersand.data.remote.model.auth.gAuthLogin.request

import com.mpersand.domain.model.auth.request.GauthLoginRequestModel

data class GauthLoginRequest(
    val code: String,
    val deviceToken: String?
)

fun GauthLoginRequestModel.asGauthLoginRequest() = GauthLoginRequest(
    code = code,
    deviceToken = deviceToken
)