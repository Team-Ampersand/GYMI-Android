package com.mpersand.presentation.viewmodel.report.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mpersand.domain.model.declaration.response.DeclarationResponseModel
import com.mpersand.domain.usecase.declaration.GetAllDeclarationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ReportListViewModel @Inject constructor(
    private val getAllDeclarationsUseCase: GetAllDeclarationsUseCase
): ContainerHost<ReportListState, ReportListSideEffect>, ViewModel() {
    override val container = container<ReportListState, ReportListSideEffect>(ReportListState())

    fun getAllDeclarations() = intent {
        viewModelScope.launch {
            getAllDeclarationsUseCase()
                .onSuccess {
                    reduce { state.copy(loading = false, reports = it) }
                }.onFailure {
                    reduce { state.copy(loading = false, error = it.message) }
                }
        }
    }
}

data class ReportListState(
    val reports: List<DeclarationResponseModel> = emptyList(),
    val loading: Boolean = true,
    val error: String? = null
)

sealed class ReportListSideEffect {

}