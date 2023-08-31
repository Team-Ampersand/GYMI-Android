package com.mpersand.presentation.viewmodel.report.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mpersand.domain.model.declaration.response.DeclarationResponseModel
import com.mpersand.domain.usecase.declaration.GetDeclarationByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ReportDetailViewModel @Inject constructor(
    private val getDeclarationByIdUseCase: GetDeclarationByIdUseCase
): ContainerHost<ReportDetailState, ReportSideEffect>, ViewModel() {
    override val container = container<ReportDetailState, ReportSideEffect>(ReportDetailState())

    fun getDeclarationById(id: Long) = intent {
        viewModelScope.launch {
            getDeclarationByIdUseCase(id)
                .onSuccess {
                    reduce { state.copy(loading = false, report = it) }
                }.onFailure {
                    reduce { state.copy(loading = false, error = it.message) }
                }
        }

    }
}

data class ReportDetailState(
    val report: DeclarationResponseModel? = null,
    val loading: Boolean = true,
    val error: String? = null
)

sealed class ReportSideEffect {

}