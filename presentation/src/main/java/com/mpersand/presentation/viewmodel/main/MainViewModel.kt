package com.mpersand.presentation.viewmodel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mpersand.domain.model.court.response.CourtResponseModel
import com.mpersand.domain.model.declaration.request.DeclarationRequestModel
import com.mpersand.domain.usecase.court.GetAllCourtsUseCase
import com.mpersand.domain.usecase.court.GetCourtByIdUseCase
import com.mpersand.domain.usecase.declaration.SubmitDeclarationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val submitDeclarationUseCase: SubmitDeclarationUseCase,
    private val getAllCourtsUseCase: GetAllCourtsUseCase,
    private val getCourtByIdUseCase: GetCourtByIdUseCase
) : ContainerHost<MainState, MainSideEffect>, ViewModel() {
    override val container = container<MainState, MainSideEffect>(MainState())

    fun submitDeclaration(courtId: Long, body: DeclarationRequestModel) = intent {
        viewModelScope.launch {
            submitDeclarationUseCase(courtId, body)
                .onSuccess {
                    postSideEffect(MainSideEffect.SnackBar("", ""))

                    reduce { state.copy(loading = false, isDeclared = true) }
                }.onFailure {
                    reduce { state.copy(loading = false, error = it.message) }
                }
        }
    }

    fun getAllCourts() = intent {
        viewModelScope.launch {
            getAllCourtsUseCase()
                .onSuccess {
                    reduce { state.copy(loading = false, allCourts = it) }
                }.onFailure {
                    reduce { state.copy(loading = false, error = it.message) }
                }
        }
    }

    fun getCourtById(courtId: Long) = intent {
        getCourtByIdUseCase(courtId)
            .onSuccess {
                reduce { state.copy(loading = false, courtDetail = it) }
            }.onFailure {
                reduce { state.copy(loading = false, error = it.message) }
            }
    }
}

data class MainState(
    val isDeclared: Boolean = false,
    val allCourts: List<CourtResponseModel> = emptyList(),
    val courtDetail: CourtResponseModel? = null,
    val loading: Boolean = true,
    val error: String? = null
)

sealed class MainSideEffect {
    data class SnackBar(val title: String, val content: String) : MainSideEffect()
}