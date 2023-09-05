package com.mpersand.presentation.view.equipment.status

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mpersand.gymi_components.component.card.GYMICard
import com.mpersand.gymi_components.theme.GYMITheme
import com.mpersand.gymi_components.theme.IcFilter

@Composable
fun EquipmentStatusScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.background(GYMITheme.colors.bg)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 37.dp, bottom = 25.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "기자재 대여 현황",
                style = GYMITheme.typography.h4,
                fontSize = 20.sp,
                color = GYMITheme.colors.bw
            )
            IcFilter(tint = GYMITheme.colors.bw)
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(vertical = 25.dp),
        ) {
            items(10) {
                GYMICard(imageUrl = "", text = "요닉스 배드민턴 라켓 $it")
            }
        }
    }
}