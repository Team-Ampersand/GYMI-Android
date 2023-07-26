package com.mpersand.data.remote.model.auth.gAuthLogin.request

import com.mpersand.domain.model.auth.request.GauthLoginRequestModel

data class GauthLoginRequest(
    val code: String,
    val token: String?
)

fun GauthLoginRequestModel.asGauthLoginRequest() = GauthLoginRequest(
    code = code,
    token = token
)