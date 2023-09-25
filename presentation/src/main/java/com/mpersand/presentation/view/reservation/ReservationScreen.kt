package com.mpersand.presentation.view.reservation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mpersand.domain.model.reservation.request.CourtNumberModel
import com.mpersand.gymi_components.component.dialog.GYMIDialog
import com.mpersand.gymi_components.theme.GYMITheme
import com.mpersand.presentation.util.DayOfWeekType
import com.mpersand.presentation.util.getDayOfWeekType
import com.mpersand.presentation.view.component.BadmintonHalfCourt
import com.mpersand.presentation.view.component.BasketballHalfCourt
import com.mpersand.presentation.view.component.CourtButtonType
import com.mpersand.presentation.view.component.CourtModal
import com.mpersand.presentation.viewmodel.reservation.ReservationViewModel

@Composable
fun ReservationScreen(
    modifier: Modifier = Modifier,
    reservationViewModel: ReservationViewModel = hiltViewModel()
) {

    var showDialog by remember { mutableStateOf(false) }
    /* TODO: 예약 현황에 따라 처리 */
    var reserved by remember { mutableStateOf<CourtNumberModel?>(null) }

    if (showDialog) {
        GYMIDialog(onDismissRequest = { showDialog = false }) {
            CourtModal(
                courtName = "",  /* TODO: 코트 상세 받아와서 표시 */
                imageUrl = "",
                personnel = "",  /* TODO: 코트 상세 받아와서 표시 */
                description = "이미 예약된 코트입니다.\n규칙을 어겼다면 신고해주세요!",
                buttonType = CourtButtonType.Cancel,
                onButtonClick = {
                    reserved?.let { reservationViewModel.cancelReservation(it) }
                },
                onDismissRequest = { showDialog = false }
            )
        }
    }

    Column(
        modifier = modifier.padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "코트 예약 하기",
            style = GYMITheme.typography.h4,
            color = GYMITheme.colors.bw
        )
        Spacer(modifier = Modifier.height(10.dp))
        when (getDayOfWeekType()) {
            DayOfWeekType.MON, DayOfWeekType.WED -> {
                repeat(2) {
                    BasketballHalfCourt(modifier = Modifier.weight(1f)) {}
                }
            }
            DayOfWeekType.TUE, DayOfWeekType.THU -> {
                repeat(4) {
                    BadmintonHalfCourt(modifier = Modifier.weight(1f)) {}
                }
            }
            DayOfWeekType.FRI -> {
                BasketballHalfCourt(modifier = Modifier.weight(4f)) {}
                repeat(2) {
                    BadmintonHalfCourt(modifier = Modifier.weight(1f)) {}
                }
            }
            else -> { } // TODO: 예약 가능한 요일이 아닌경우
        }
        Spacer(modifier = Modifier.height(15.dp))
    }
}

@Preview
@Composable
fun ReservationScreenPreview() {
    ReservationScreen()
}
