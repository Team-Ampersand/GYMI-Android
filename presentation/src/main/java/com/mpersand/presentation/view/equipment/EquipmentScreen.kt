package com.mpersand.presentation.view.equipment

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mpersand.gymi_components.component.card.GYMICard
import com.mpersand.gymi_components.component.header.GYMIHeader
import com.mpersand.gymi_components.component.navbar.GYMINavBar
import com.mpersand.gymi_components.component.navbar.GYMINavItem
import com.mpersand.gymi_components.theme.GYMITheme
import com.mpersand.gymi_components.theme.IcEquipment
import com.mpersand.gymi_components.theme.IcFilter
import com.mpersand.gymi_components.theme.IcHome
import com.mpersand.gymi_components.theme.IcReservation

@Composable
fun EquipmentScreen(modifier: Modifier = Modifier) {
    var selected by remember { mutableStateOf(2) }

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(GYMITheme.colors.bg),
        topBar = {
            GYMIHeader(
                navigateToMain = { /*TODO*/ },
                navigateToNotice = { /*TODO*/ },
                navigationToProfile = { /*TODO*/ }
            )
        },
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
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 30.dp, bottom = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "기자재 예약 하기",
                    style = GYMITheme.typography.h4,
                    color = GYMITheme.colors.bw
                )
                IcFilter(
                    modifier = Modifier.clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null,
                        onClick = {}
                    ),
                    tint = GYMITheme.colors.bw
                )
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(bottom = 15.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(10) {
                    GYMICard(
                        imageUrl = "",
                        text = "요넥스 배드민턴 라켓 $it"
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Preview
@Composable
fun EquipmentScreenPreview() {
    EquipmentScreen()
}