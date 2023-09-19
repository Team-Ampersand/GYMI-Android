package com.mpersand.presentation.viewmodel.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mpersand.domain.model.auth.request.GauthLoginRequestModel
import com.mpersand.domain.usecase.auth.GauthLoginUseCase
import com.mpersand.domain.usecase.auth.GauthLogoutUseCase
import com.mpersand.domain.usecase.auth.SaveTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val gAuthLoginUseCase: GauthLoginUseCase,
    private val gAuthLogoutUseCase: GauthLogoutUseCase,
    private val saveTokenUseCase: SaveTokenUseCase,
) : ContainerHost<AuthState, AuthSideEffect>, ViewModel() {

    override val container = container<AuthState, AuthSideEffect>(AuthState())

    fun gAuthLogin(gAuthLoginRequestModel: GauthLoginRequestModel) = intent {
        viewModelScope.launch {
            gAuthLoginUseCase(gAuthLoginRequestModel)
                .onSuccess {
                    Log.d("Success", "gAuthLogin: $it")
                    saveTokenUseCase(
                        accessToken = it.accessToken,
                        refreshToken = it.refreshToken,
                        accessExp = it.accessExp,
                        refreshExp = it.refreshExp
                    )
                    reduce {
                        state.copy(
                            success = true,
                            loading = false,
                            error = ""
                        )
                    }
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

data class AuthState(
    val success: Boolean = false,
    val loading: Boolean = true,
    val error: String? = null
)

sealed class AuthSideEffect {}