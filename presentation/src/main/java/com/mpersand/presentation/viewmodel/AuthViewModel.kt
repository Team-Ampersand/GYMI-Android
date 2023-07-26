package com.mpersand.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mpersand.domain.model.auth.request.GauthLoginRequestModel
import com.mpersand.domain.usecase.GauthLoginUseCase
import com.mpersand.domain.usecase.GauthLogoutUseCase
import com.mpersand.domain.usecase.SaveTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor (
    private val gAuthLoginUseCase: GauthLoginUseCase,
    private val gAuthLogoutUseCase: GauthLogoutUseCase,
    private val saveTokenUseCase: SaveTokenUseCase
): ViewModel() {
    fun gAuthLogin(gAuthLoginRequestModel: GauthLoginRequestModel) {
        viewModelScope.launch {
            gAuthLoginUseCase(gAuthLoginRequestModel)
                .onSuccess {
                    Log.d("Success", "gAuthLogin: $it")
                    saveTokenUseCase(
                        accessToken = it.accessToken,
                        refreshToken = it.refreshToken,
                        accessExp = it.accessExp.toString(),
                        refreshExp = it.refreshExp.toString()
                    )
                }
                .onFailure {
                    Log.d("Failure", "gAuthLogin: ${it.message}")
                }
        }
    }

    fun gAuthLogout() {
        viewModelScope.launch {
            gAuthLogoutUseCase()
                .onSuccess {
                    Log.d("Success", "gAuthLogout: $it")
                }
                .onFailure {
                    Log.d("Failure", "gAuthLogout: ${it.message}")
                }
        }
    }

}