package com.mpersand.presentation.view.notice.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mpersand.gymi_components.component.header.GYMIHeader
import com.mpersand.gymi_components.component.item.GYMINoticeItem
import com.mpersand.gymi_components.component.navbar.GYMINavBar
import com.mpersand.gymi_components.component.navbar.GYMINavItem
import com.mpersand.gymi_components.theme.GYMITheme
import com.mpersand.gymi_components.theme.IcEquipment
import com.mpersand.gymi_components.theme.IcHome
import com.mpersand.gymi_components.theme.IcPlus
import com.mpersand.gymi_components.theme.IcReservation

@Composable
fun NoticeListScreen(modifier: Modifier = Modifier) {
    var selected by remember { mutableStateOf(4) }
    Scaffold(
        scaffoldState = rememberScaffoldState(),
        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = GYMITheme.colors.n4,
                onClick = { /*TODO*/ }
            ) { IcPlus(tint = GYMITheme.colors.bw) }
        },
        isFloatingActionButtonDocked = false,
        bottomBar = {
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
    ) { contentPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(GYMITheme.colors.bg)
                .padding(contentPadding)
        ) {
            GYMIHeader(navigateToMain = {}, navigateToNotice = {}, navigationToProfile = {})
            Spacer(modifier = Modifier.height(35.dp))
            Column(modifier = modifier.padding(horizontal = 20.dp)) {
                Text(
                    text = "공지사항",
                    style = GYMITheme.typography.h4,
                    color = GYMITheme.colors.bw
                )
                Spacer(modifier = Modifier.height(25.dp))
                LazyColumn(modifier = Modifier.weight(1f)) {
                    items(10) {
                        GYMINoticeItem(
                            title = "Title 0${it + 1}",
                            content = "content content content",
                            date = "2023.09.0${it + 1}"
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
        }
    }
}
