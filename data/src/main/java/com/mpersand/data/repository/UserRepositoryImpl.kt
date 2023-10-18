package com.mpersand.data.repository

import com.mpersand.data.remote.datasource.user.UserDataSource
import com.mpersand.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
): UserRepository {
    override fun getMyReservedCourt(): String = userDataSource.getMyReservedCourt()
}
