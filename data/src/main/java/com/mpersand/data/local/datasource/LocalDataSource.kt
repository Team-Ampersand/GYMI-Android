package com.mpersand.data.local.datasource

import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun saveToken(
        accessToken: String,
        refreshToken: String,
        accessExp: String,
        refreshExp: String
    )

    suspend fun getAccessToken(): Flow<String>

    suspend fun getRefreshToken(): Flow<String>

    suspend fun getAccessTokenExp(): Flow<String>

    suspend fun getRefreshTokenExp(): Flow<String>
}