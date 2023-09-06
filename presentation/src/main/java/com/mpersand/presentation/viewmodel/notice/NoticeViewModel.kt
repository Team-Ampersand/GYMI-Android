package com.mpersand.presentation.viewmodel.notice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mpersand.domain.usecase.notice.GetAllNoticeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class NoticeViewModel @Inject constructor(
    private val getAllNoticeUseCase: GetAllNoticeUseCase
) : ContainerHost<NoticeState, NoticeSideEffect>, ViewModel() {
    override val container = container<NoticeState, NoticeSideEffect>(NoticeState())

    fun getAllNotice() = intent {
        viewModelScope.launch {
            getAllNoticeUseCase()
                .onSuccess {
                    reduce { state.copy(loading = false, isSuccess = true) }
                }
                .onFailure {
                    reduce { state.copy(loading = false, error = it.message) }
                }
        }
    }
}

data class NoticeState(
    val isSuccess: Boolean = false,
    val loading: Boolean = true,
    val error: String? = null
)

sealed class NoticeSideEffect