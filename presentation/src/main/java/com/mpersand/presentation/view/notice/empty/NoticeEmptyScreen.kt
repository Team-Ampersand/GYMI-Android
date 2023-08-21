package com.mpersand.presentation.view.notice.empty

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mpersand.gymi_components.component.header.GYMIHeader
import com.mpersand.gymi_components.component.navbar.GYMINavBar
import com.mpersand.gymi_components.component.navbar.GYMINavItem
import com.mpersand.gymi_components.theme.GYMITheme
import com.mpersand.gymi_components.theme.IcEquipment
import com.mpersand.gymi_components.theme.IcHome
import com.mpersand.gymi_components.theme.IcNotice
import com.mpersand.gymi_components.theme.IcReservation

@Composable
fun NoticeEmptyScreen(modifier: Modifier = Modifier) {
    Scaffold(
        scaffoldState = rememberScaffoldState(),
        topBar = {
            GYMIHeader(
                navigateToMain = { },
                navigateToNotice = { },
                navigationToProfile = { }
            )
        },
        bottomBar = {
            val navItems = listOf("reservation", "home", "equipment")
            var selected by remember { mutableStateOf(4) }
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
    ) { contentPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(GYMITheme.colors.bg)
                .padding(contentPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IcNotice(
                modifier = Modifier.size(180.dp),
                tint = GYMITheme.colors.n2
            )
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "공지사항이 없습니다.",
                style = GYMITheme.typography.subtitle1,
                color = GYMITheme.colors.bw
            )
        }
    }
}
