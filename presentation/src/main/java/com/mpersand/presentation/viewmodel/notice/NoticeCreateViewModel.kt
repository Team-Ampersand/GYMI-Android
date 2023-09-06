package com.mpersand.presentation.viewmodel.notice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mpersand.domain.usecase.notice.CreateNoticeUseCase
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
class NoticeWriteViewModel @Inject constructor(
    private val createNoticeUseCase: CreateNoticeUseCase
) : ContainerHost<NoticeCreateState, NoticeCreateSideEffect>, ViewModel() {
    override val container = container<NoticeCreateState, NoticeCreateSideEffect>(NoticeCreateState())

    fun createNotice(
        notice: HashMap<String, RequestBody>,
        file: MultipartBody.Part
    ) = intent {
        viewModelScope.launch {
            createNoticeUseCase(notice, file)
                .onSuccess {
                    postSideEffect(NoticeCreateSideEffect.SnackBar("", ""))
                    reduce { state.copy(loading = false, isSuccess = true) }
                }
                .onFailure {
                    reduce { state.copy(loading = false, error = it.message) }
                }
        }
    }
}

data class NoticeCreateState(
    val isSuccess: Boolean = false,
    val loading: Boolean = true,
    val error: String? = null
)

sealed class NoticeCreateSideEffect {
    data class SnackBar(val title: String, val content: String) : NoticeCreateSideEffect()
}