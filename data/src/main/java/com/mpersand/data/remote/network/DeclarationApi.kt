package com.mpersand.data.remote.network

import com.mpersand.data.remote.model.declaration.request.DeclarationRequest
import com.mpersand.data.remote.model.declaration.response.DeclarationResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DeclarationApi {
    @GET("declaration")
    suspend fun getAllDeclarations(): List<DeclarationResponse>

    @GET("declaration/{id}")
    suspend fun getDeclarationById(
        @Path("id") id: Long
    ): DeclarationResponse

    @POST("declaration")
    suspend fun submitDeclaration(
        @Body body: DeclarationRequest
    )
}