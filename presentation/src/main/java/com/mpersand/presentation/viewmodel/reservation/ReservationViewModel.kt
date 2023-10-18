package com.mpersand.presentation.viewmodel.reservation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mpersand.domain.model.court.response.CourtListResponseModel
import com.mpersand.domain.model.reservation.request.CourtNumberModel
import com.mpersand.domain.usecase.court.GetAllCourtsUseCase
import com.mpersand.domain.usecase.reservation.CancelReservationUseCase
import com.mpersand.domain.usecase.reservation.ReserveCourtUseCase
import com.mpersand.domain.usecase.user.GetMyReservedCourtUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ReservationViewModel @Inject constructor(
    private val reserveCourtUseCase: ReserveCourtUseCase,
    private val cancelReservationUseCase: CancelReservationUseCase,
    private val getAllCourtsUseCase: GetAllCourtsUseCase,
    private val getMyReservedCourtUseCase: GetMyReservedCourtUseCase
) : ContainerHost<ReservationState, ReservationSideEffect>, ViewModel() {
    override val container = container<ReservationState, ReservationSideEffect>(ReservationState())
    fun reserveCourt(courtNumberModel: CourtNumberModel) = intent {
        viewModelScope.launch {
            reserveCourtUseCase(courtNumberModel)
                .onSuccess {
                    postSideEffect(
                        ReservationSideEffect.SnackBar(
                            title = "코트 예약이 완료되었습니다.",
                            content = "코트를 깨끗하게 사용해주세요.\n규칙을 어길시 체육관 이용이 금지될 수 있습니다!",
                            isDone = true
                        )
                    )

                    reduce { state.copy(reserved = courtNumberModel) }
                }.onFailure {
                    postSideEffect(
                        ReservationSideEffect.SnackBar(
                            title = "코트 예약에 실패하였습니다.",
                            content = it.message ?: "알 수 없는 오류로 예약에 실패하였습니다.",
                            isDone = false
                        )
                    )

                    reduce { state.copy(error = it.message) }
                }
        }
    }

    fun cancelReservation(courtNumberModel: CourtNumberModel) = intent {
        viewModelScope.launch {
            cancelReservationUseCase(courtNumberModel)
                .onSuccess {
                    reduce { state.copy(reserved = null) }
                }.onFailure {
                    reduce { state.copy(error = it.message) }
                }
        }
    }

    fun getAllCourts() = intent {
        viewModelScope.launch {
            getAllCourtsUseCase()
                .onSuccess {
                    reduce { state.copy(allCourts = it) }
                }.onFailure {
                    reduce { state.copy(error = it.message) }
                }
        }
    }

    fun getMyReservedCourt() = intent {
        viewModelScope.launch {
            getMyReservedCourtUseCase()
                .onSuccess {
                    reduce {
                        state.copy(reserved = CourtNumberModel.values().find { court -> court.name == it })
                    }
                }.onFailure {
                    reduce { state.copy(error = it.message) }
                }
        }
    }
}

data class ReservationState(
    val allCourts: CourtListResponseModel? = null,
    val reserved: CourtNumberModel? = null,
    val loading: Boolean = true,
    val error: String? = null
)

sealed class ReservationSideEffect {
    data class SnackBar(val title: String, val content: String, val isDone: Boolean) : ReservationSideEffect()
}
