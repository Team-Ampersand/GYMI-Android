package com.mpersand.data.remote.datasource.declaration

import com.mpersand.data.remote.model.declaration.request.DeclarationRequest
import com.mpersand.data.remote.model.declaration.response.DeclarationResponse

interface DeclarationDataSource {
    suspend fun getAllDeclarations(): List<DeclarationResponse>

    suspend fun getDeclarationById(id: Long): DeclarationResponse

    suspend fun submitDeclaration(body: DeclarationRequest)
}