package com.mpersand.domain.model.auth.request

data class GauthLoginRequestModel(
    val code: String,
    val token: String?
)
