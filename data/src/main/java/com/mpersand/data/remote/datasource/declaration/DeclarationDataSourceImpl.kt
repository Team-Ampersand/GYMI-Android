package com.mpersand.data.remote.datasource.declaration

import com.mpersand.data.remote.model.declaration.request.DeclarationRequest
import com.mpersand.data.remote.model.declaration.response.DeclarationResponse
import com.mpersand.data.remote.network.DeclarationApi
import javax.inject.Inject

class DeclarationDataSourceImpl @Inject constructor(
    private val declarationApi: DeclarationApi
): DeclarationDataSource {
    override suspend fun getAllDeclarations(): List<DeclarationResponse> = declarationApi.getAllDeclarations()

    override suspend fun getDeclarationById(id: Long): DeclarationResponse = declarationApi.getDeclarationById(id)

    override suspend fun submitDeclaration(courtId: Long, body: DeclarationRequest) =
        declarationApi.submitDeclaration(courtId, body)
}