package com.mpersand.presentation.view.reservation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mpersand.domain.model.reservation.request.CourtNumberModel
import com.mpersand.gymi_components.component.dialog.GYMIDialog
import com.mpersand.gymi_components.component.snackbar.GYMISnackbar
import com.mpersand.gymi_components.theme.GYMITheme
import com.mpersand.presentation.util.DayOfWeekType
import com.mpersand.presentation.util.getDayOfWeekType
import com.mpersand.presentation.view.component.BadmintonHalfCourt
import com.mpersand.presentation.view.component.BasketballHalfCourt
import com.mpersand.presentation.view.component.CourtButtonType
import com.mpersand.presentation.view.component.CourtModal
import com.mpersand.presentation.viewmodel.reservation.ReservationSideEffect
import com.mpersand.presentation.viewmodel.reservation.ReservationViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun ReservationScreen(
    modifier: Modifier = Modifier,
    reservationViewModel: ReservationViewModel = hiltViewModel()
) {
    val uiState by reservationViewModel.collectAsState()
    val reserved by remember { mutableStateOf(uiState.reserved) }
    val coroutineScope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    var showDialog by remember { mutableStateOf(false) }
    var selectedCourt by remember { mutableStateOf<CourtNumberModel?>(null) }
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var isDone by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        reservationViewModel.getAllCourts()
        reservationViewModel.getMyReservedCourt()
    }

    if (showDialog) {
        uiState.allCourts?.let { allCourts ->
            val court = allCourts.courtList.single { it.courtNumber == selectedCourt!!.name }
            GYMIDialog(onDismissRequest = { showDialog = false }) {
                CourtModal(
                    courtName = court.name,
                    imageUrl = "",
                    personnel = if (court.count > 0) {
                        court.reservationUsers.joinToString(
                            separator = ", ",
                            transform = { it.nickname }
                        )
                    } else {
                        "미정"
                    },
                    description = if (court.count > 0) {
                        "이미 예약된 코트입니다.\n규칙을 어겼다면 신고해주세요!"
                    } else {
                        "예약되지 않은 코트입니다.\n코트를 이용하고 싶으시면 예약해주세요!"
                    },
                    buttonType = CourtButtonType.Cancel,
                    onButtonClick = {
                        reserved?.let { reservationViewModel.cancelReservation(it) }
                    },
                    onDismissRequest = { showDialog = false }
                )
            }

        }
    }

    reservationViewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is ReservationSideEffect.SnackBar -> {
                title = sideEffect.title
                content = sideEffect.content
                isDone = sideEffect.isDone

                coroutineScope.launch {
                    snackBarHostState.currentSnackbarData?.dismiss()
                    snackBarHostState.showSnackbar("")
                }
            }
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState) {
                GYMISnackbar(
                    title = title,
                    content = content,
                    isDone = isDone
                )
            }
        },
    ) { paddingValues ->
        if (uiState.allCourts != null) {
            Column(
                modifier = modifier
                    .padding(paddingValues)
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "코트 예약 하기",
                    style = GYMITheme.typography.h4,
                    color = GYMITheme.colors.bw
                )
                Spacer(modifier = Modifier.height(10.dp))
                val allCourts = uiState.allCourts!!.courtList
                when (getDayOfWeekType()) {
                    DayOfWeekType.MON, DayOfWeekType.WED -> {
                        repeat(2) { column ->
                            BasketballHalfCourt(
                                modifier = Modifier.weight(1f),
                                checkReserved = { row ->
                                    val courtIdx = calculateCourtNumber(row + 1, column + 1)
                                    allCourts[courtIdx].count == allCourts[courtIdx].maxCount
                                },
                                onClick = { row ->
                                    val courtIdx = calculateCourtNumber(row + 1, column + 1)
                                    selectedCourt = setSelectedCourt(courtIdx)
                                    reservationViewModel.reserveCourt(selectedCourt!!)
                                },
                                onLongClick = { row ->
                                    val courtIdx = calculateCourtNumber(row + 1, column + 1)
                                    selectedCourt = setSelectedCourt(courtIdx)
                                    showDialog = true
                                }
                            )
                        }
                    }
                    DayOfWeekType.TUE, DayOfWeekType.THU -> {
                        repeat(4) { index ->
                            BadmintonHalfCourt(
                                modifier = Modifier.weight(1f),
                                isReserved = allCourts[index].count == allCourts[index].maxCount,
                                onClick = {
                                    selectedCourt = when (index + 1) {
                                        1 -> CourtNumberModel.FIRST
                                        2 -> CourtNumberModel.SECOND
                                        3 -> CourtNumberModel.THREE
                                        else -> CourtNumberModel.FOUR
                                    }
                                    reservationViewModel.reserveCourt(selectedCourt!!)
                                },
                                onLongClick = {
                                    selectedCourt = when (index + 1) {
                                        1 -> CourtNumberModel.FIRST
                                        2 -> CourtNumberModel.SECOND
                                        3 -> CourtNumberModel.THREE
                                        else -> CourtNumberModel.FOUR
                                    }
                                    showDialog = true
                                }
                            )
                        }
                    }
                    DayOfWeekType.FRI -> {
                        BasketballHalfCourt(
                            modifier = Modifier.weight(4f),
                            checkReserved = { allCourts[it].count == allCourts[it].maxCount },
                            onClick = {
                                selectedCourt = setSelectedCourt(it + 1)
                                reservationViewModel.reserveCourt(selectedCourt!!)
                            },
                            onLongClick = {
                                selectedCourt = setSelectedCourt(it + 1)
                                showDialog = true
                            }
                        )
                        repeat(2) {
                            BadmintonHalfCourt(
                                modifier = Modifier.weight(1f),
                                isReserved = allCourts[it + 2].count == allCourts[it + 2].maxCount,
                                onClick = {
                                    selectedCourt = setSelectedCourt(it + 3)
                                    reservationViewModel.reserveCourt(selectedCourt!!)
                                },
                                onLongClick = {
                                    selectedCourt = setSelectedCourt(it + 3)
                                    showDialog = true
                                }
                            )
                        }
                    }
                    else -> {} // TODO: 예약 가능한 요일이 아닌경우
                }
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}

private fun setSelectedCourt(courtId: Int): CourtNumberModel = when (courtId) {
    1 -> CourtNumberModel.FIRST
    2 -> CourtNumberModel.SECOND
    3 -> CourtNumberModel.THREE
    else -> CourtNumberModel.FOUR
}

private fun calculateCourtNumber(xIndex: Int, yIndex: Int) = (xIndex - 1) * 2 + yIndex

@Preview
@Composable
fun ReservationScreenPreview() {
    ReservationScreen()
}
