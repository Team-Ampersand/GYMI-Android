package com.mpersand.presentation.viewmodel.notice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
class NoticeModifyViewModel @Inject constructor(
    private val modifyNoticeUseCase: ModifyNoticeUseCase
) : ContainerHost<NoticeModifyState, NoticeModifySideEffect>, ViewModel() {
    override val container = container<NoticeModifyState, NoticeModifySideEffect>(NoticeModifyState())

    fun modifyNotice(
        id: Long,
        notice: HashMap<String, RequestBody>,
        file: MultipartBody.Part
    ) = intent {
        viewModelScope.launch {
            modifyNoticeUseCase(id, notice, file)
                .onSuccess {
                    postSideEffect(NoticeModifySideEffect.SnackBar("", ""))
                    reduce { state.copy(loading = false, isSuccess = true) }
                }
                .onFailure {
                    reduce { state.copy(loading = false, error = it.message) }
                }
        }
    }
}

data class NoticeModifyState(
    val isSuccess: Boolean = false,
    val loading: Boolean = true,
    val error: String? = null
)

sealed class NoticeModifySideEffect {
    data class SnackBar(val title: String, val content: String) : NoticeModifySideEffect()
}
