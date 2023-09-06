package com.mpersand.presentation.viewmodel.ban

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mpersand.domain.usecase.court.BanCourtByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class BanViewModel @Inject constructor(
    private val banCourtByIdUseCase: BanCourtByIdUseCase
): ContainerHost<BanState, BanSideEffect>, ViewModel() {
    override val container = container<BanState, BanSideEffect>(BanState())

    fun banCourtById(courtId: Long) = intent {
        viewModelScope.launch {
            banCourtByIdUseCase(courtId)
                .onSuccess {
                    reduce { state.copy(loading = false, success = true) }
                }.onFailure {
                    reduce { state.copy(loading = false, error = it.message) }
                }
        }
    }
}

data class BanState(
    val success: Boolean = false,
    val loading: Boolean = true,
    val error: String? = null
)

sealed class BanSideEffect {}