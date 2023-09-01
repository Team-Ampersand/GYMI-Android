package com.mpersand.presentation.view.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mpersand.gymi_components.theme.GYMITheme
import com.mpersand.gymi_components.theme.GYMITypography
import com.mpersand.presentation.util.DayOfWeekType
import com.mpersand.presentation.util.getDayOfWeekType
import com.mpersand.presentation.view.component.BadmintonHalfCourt
import com.mpersand.presentation.view.component.BasketballHalfCourt

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "코트 예약 현황",
            style = GYMITypography.h4,
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
            else -> {} // TODO: 예약 가능한 요일이 아닌경우
        }
        Spacer(modifier = Modifier.height(15.dp))
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}