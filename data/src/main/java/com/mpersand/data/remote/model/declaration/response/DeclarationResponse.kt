package com.mpersand.data.remote.model.declaration.response

import com.mpersand.data.remote.model.declaration.util.DeclarationType
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DeclarationResponse(
    val id: Long,
    val type: DeclarationType,
    val content: String?
)