package com.mpersand.presentation.view.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    dayOfWeek: String,
    navigateToMain: () -> Unit,
    navigateToNotice: () -> Unit,
    navigateToProfile: () -> Unit
) {
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
                style = GYMITypography.h4
            )
            Spacer(modifier = Modifier.height(10.dp))
            when (dayOfWeek) {
                "월", "수" -> {
                    repeat(2) {
                        Row(modifier = modifier.weight(1f)) {
                            repeat(2) {
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
                        Spacer(modifier = Modifier.height(2.dp))
                    }
                }

                "화", "목" -> {
                    repeat(4) {
                        GYMIBadmintonCourt(
                            modifier = modifier
                                .fillMaxWidth()
                                .weight(1f),
                            isReserved = false
                        ) {}
                        Spacer(modifier = Modifier.height(2.dp))
                    }
                }

                "금" -> {
                    Row(modifier = modifier.weight(2f)) {
                        repeat(2) {
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
                    Spacer(modifier = Modifier.height(2.dp))
                    repeat(2) {
                        GYMIBadmintonCourt(
                            modifier = modifier
                                .fillMaxWidth()
                                .weight(1f),
                            isReserved = false
                        ) {}
                        Spacer(modifier = Modifier.height(2.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
            GYMINavBar {
                GYMINavItem(
                    selected = false,
                    icon = { IcReservation(tint = LocalContentColor.current) }) {}
                GYMINavItem(selected = true, icon = { IcHome(tint = LocalContentColor.current) }) {}
                GYMINavItem(
                    selected = false,
                    icon = { IcEquipment(tint = LocalContentColor.current) }) {}
            }
        }
    }
}
