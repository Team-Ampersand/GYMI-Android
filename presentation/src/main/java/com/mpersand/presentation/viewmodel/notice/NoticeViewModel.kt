package com.mpersand.presentation.viewmodel.notice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mpersand.domain.usecase.notice.CreateNoticeUseCase
import com.mpersand.domain.usecase.notice.DeleteNoticeUseCase
import com.mpersand.domain.usecase.notice.GetAllNoticeUseCase
import com.mpersand.domain.usecase.notice.GetDetailNoticeUsecase
import com.mpersand.domain.usecase.notice.ModifyNoticeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class NoticeViewModel @Inject constructor(
    private val createNoticeUseCase: CreateNoticeUseCase,
    private val deleteNoticeUseCase: DeleteNoticeUseCase,
    private val modifyNoticeUseCase: ModifyNoticeUseCase,
    private val getAllNoticeUseCase: GetAllNoticeUseCase,
    private val getDetailNoticeUsecase: GetDetailNoticeUsecase
) : ContainerHost<NoticeState, NoticeSideEffect>, ViewModel() {
    override val container = container<NoticeState, NoticeSideEffect>(NoticeState())

    fun createNotice(
        notice: HashMap<String, RequestBody>,
        file: MultipartBody.Part
    ) = intent {
        viewModelScope.launch {
            createNoticeUseCase(notice, file)
                .onSuccess {
                    postSideEffect(NoticeSideEffect.SnackBar("", ""))
                    reduce { state.copy(loading = false, isSuccess = true) }
                }
                .onFailure {
                    reduce { state.copy(loading = false, error = it.message) }
                }
        }
    }

    fun deleteNotice(id: Long) = intent {
        viewModelScope.launch {
            deleteNoticeUseCase(id)
                .onSuccess {
                    postSideEffect(NoticeSideEffect.SnackBar("", ""))
                    reduce { state.copy(loading = false, isSuccess = true) }
                }
                .onFailure {
                    reduce { state.copy(loading = false, error = it.message) }
                }
        }
    }

    fun modifyNotice(
        id: Long,
        notice: HashMap<String, RequestBody>,
        file: MultipartBody.Part
    ) = intent {
        viewModelScope.launch {
            modifyNoticeUseCase(id, notice, file)
                .onSuccess {
                    postSideEffect(NoticeSideEffect.SnackBar("", ""))
                    reduce { state.copy(loading = false, isSuccess = true) }
                }
                .onFailure {
                    reduce { state.copy(loading = false, error = it.message) }
                }
        }
    }

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

data class NoticeState(
    val isSuccess: Boolean = false,
    val loading: Boolean = true,
    val error: String? = null
)

sealed class NoticeSideEffect {
    data class SnackBar(val title: String, val content: String) : NoticeSideEffect()
}