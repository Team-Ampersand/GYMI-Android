package com.mpersand.presentation.viewmodel.notice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mpersand.domain.usecase.notice.DeleteNoticeUseCase
import com.mpersand.domain.usecase.notice.GetDetailNoticeUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class NoticeDetailViewModel @Inject constructor(
    private val deleteNoticeUseCase: DeleteNoticeUseCase,
    private val getDetailNoticeUsecase: GetDetailNoticeUsecase
) : ContainerHost<NoticeDetailState, NoticeDetailSideEffect>, ViewModel() {
    override val container = container<NoticeDetailState, NoticeDetailSideEffect>(NoticeDetailState())
    fun deleteNotice(id: Long) = intent {
        viewModelScope.launch {
            deleteNoticeUseCase(id)
                .onSuccess {
                    postSideEffect(NoticeDetailSideEffect.SnackBar("", ""))
                    reduce { state.copy(loading = false, isSuccess = true) }
                }
                .onFailure {
                    reduce { state.copy(loading = false, error = it.message) }
                }
        }
    }

    fun getDetailNotice(id: Long) = intent {
        viewModelScope.launch {
            getDetailNoticeUsecase(id)
                .onSuccess {
                    reduce { state.copy(loading = false, isSuccess = true) }
                }
                .onFailure {
                    reduce { state.copy(loading = false, error = it.message) }
                }
        }
    }
}

data class NoticeDetailState(
    val isSuccess: Boolean = false,
    val loading: Boolean = true,
    val error: String? = null
)

sealed class NoticeDetailSideEffect {
    data class SnackBar(val title: String, val content: String) : NoticeDetailSideEffect()
}
