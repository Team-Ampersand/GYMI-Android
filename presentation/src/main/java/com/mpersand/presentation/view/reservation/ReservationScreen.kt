package com.mpersand.presentation.view.reservation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mpersand.gymi_components.component.header.GYMIHeader
import com.mpersand.gymi_components.component.navbar.GYMINavBar
import com.mpersand.gymi_components.component.navbar.GYMINavItem
import com.mpersand.gymi_components.theme.GYMITheme
import com.mpersand.gymi_components.theme.IcEquipment
import com.mpersand.gymi_components.theme.IcHome
import com.mpersand.gymi_components.theme.IcReservation
import com.mpersand.presentation.view.component.BadmintonHalfCourt
import com.mpersand.presentation.view.component.BasketballHalfCourt

@Composable
fun ReservationScreen(
    modifier: Modifier = Modifier,
    dayOfWeek: String,
) {
    var selected by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(GYMITheme.colors.bg)
    ) {
        GYMIHeader(
            navigateToMain = { /*TODO*/ },
            navigateToNotice = { /*TODO*/ },
            navigationToProfile = { /*TODO*/ }
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 30.dp)
                .weight(1f)
        ) {
            Text(
                text = "코트 예약 하기",
                style = GYMITheme.typography.h4,
                color = GYMITheme.colors.bw
            )
            Spacer(modifier = Modifier.height(10.dp))
            when (dayOfWeek) {
                "월", "수" -> {
                    repeat(2) {
                        BasketballHalfCourt(modifier = Modifier.weight(1f)) {}
                    }
                }

                "화", "목" -> {
                    repeat(4) {
                        BadmintonHalfCourt(modifier = Modifier.weight(1f)) {}
                    }
                }

                "금" -> {
                    BasketballHalfCourt(modifier = Modifier.weight(4f)) {}
                    Spacer(modifier = Modifier.height(5.dp))
                    repeat(2) {
                        BadmintonHalfCourt(modifier = Modifier.weight(1f)) {}
                    }
                }
            }
        }
        val navItems = listOf("reservation", "home", "equipment")
        GYMINavBar {
            repeat(3) {
                GYMINavItem(
                    selected = selected == it,
                    icon = {
                        when (navItems[it]) {
                            "reservation" -> IcReservation(tint = LocalContentColor.current)
                            "home" -> IcHome(tint = LocalContentColor.current)
                            "equipment" -> IcEquipment(tint = LocalContentColor.current)
                        }
                    }
                ) {
                    selected = it
                }
            }
        }
    }
}
