package com.mpersand.domain.model.declaration.response

import com.mpersand.domain.model.declaration.util.DeclarationTypeModel

data class DeclarationResponseModel(
    val id: Long,
    val type: DeclarationTypeModel,
    val content: String?
)