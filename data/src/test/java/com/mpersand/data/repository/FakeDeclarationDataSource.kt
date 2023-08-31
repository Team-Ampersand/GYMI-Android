package com.mpersand.data.repository

import com.mpersand.data.remote.datasource.declaration.DeclarationDataSource
import com.mpersand.data.remote.model.declaration.request.DeclarationRequest
import com.mpersand.data.remote.model.declaration.response.DeclarationResponse

class FakeDeclarationDataSource(private var declarations: List<DeclarationResponse>) : DeclarationDataSource {
    override suspend fun getAllDeclarations(): List<DeclarationResponse> = declarations

    override suspend fun getDeclarationById(id: Long): DeclarationResponse = declarations.single { it.id == id }

    override suspend fun submitDeclaration(body: DeclarationRequest) {
        declarations = declarations.plus(
            DeclarationResponse(id = declarations.size.toLong(), type = body.type, content = body.content)
        )
    }
}