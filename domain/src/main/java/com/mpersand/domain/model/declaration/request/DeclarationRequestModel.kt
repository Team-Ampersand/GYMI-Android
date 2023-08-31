package com.mpersand.domain.model.declaration.request

import com.mpersand.domain.model.declaration.util.DeclarationTypeModel

data class DeclarationRequestModel(
    val type: DeclarationTypeModel,
    val content: String?
)