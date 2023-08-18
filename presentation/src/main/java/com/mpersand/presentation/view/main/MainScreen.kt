package com.mpersand.presentation.view.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.mpersand.gymi_components.component.court.GYMIBadmintonCourt
import com.mpersand.gymi_components.component.court.GYMIBasketballCourt
import com.mpersand.gymi_components.component.header.GYMIHeader
import com.mpersand.gymi_components.component.navbar.GYMINavBar
import com.mpersand.gymi_components.component.navbar.GYMINavItem
import com.mpersand.gymi_components.theme.GYMITheme
import com.mpersand.gymi_components.theme.GYMITypography
import com.mpersand.gymi_components.theme.IcEquipment
import com.mpersand.gymi_components.theme.IcHome
import com.mpersand.gymi_components.theme.IcReservation

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    dayOfWeek: String,
    navigateToMain: () -> Unit,
    navigateToNotice: () -> Unit,
    navigateToProfile: () -> Unit
) {
    var selected by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(GYMITheme.colors.bg)
    ) {
        GYMIHeader(
            navigateToMain = navigateToMain,
            navigateToNotice = navigateToNotice,
            navigationToProfile = navigateToProfile
        )
        Spacer(modifier = Modifier.height(30.dp))
        Column(modifier = modifier.padding(horizontal = 20.dp)) {
            Text(
                text = "코트 예약 현황",
                style = GYMITypography.h4,
                color = GYMITheme.colors.bw
            )
            Spacer(modifier = Modifier.height(10.dp))
            when (dayOfWeek) {
                "월", "수" -> {
                    repeat(2) {
                        GYMIBasketballHalfCourt(repeat = 2, weight = 1f)
                    }
                }
                "화", "목" -> { GYMIBadmintonHalfCourt(repeat = 4) }
                "금" -> {
                    GYMIBasketballHalfCourt(repeat = 2, weight = 2f)
                    Spacer(modifier = Modifier.height(2.dp))
                    GYMIBadmintonHalfCourt(repeat = 2)
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
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
}

@Composable
fun ColumnScope.GYMIBadmintonHalfCourt(
    modifier: Modifier = Modifier,
    repeat: Int
) {
    repeat(repeat) {
        GYMIBadmintonCourt(
            modifier = modifier
                .fillMaxWidth()
                .weight(1f),
            isReserved = false
        ) {}
        Spacer(modifier = Modifier.height(2.dp))
    }
}

@Composable
fun ColumnScope.GYMIBasketballHalfCourt(
    modifier: Modifier = Modifier,
    repeat: Int,
    weight: Float
) {
    Row(modifier = modifier.weight(weight)) {
        repeat(repeat) {
            GYMIBasketballCourt(
                modifier = modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .graphicsLayer {
                        if (it % 2 != 0) rotationY = 180f
                    },
                isReserved = false
            ) {}
            Spacer(modifier = Modifier.width(2.dp))
        }
    }
}
