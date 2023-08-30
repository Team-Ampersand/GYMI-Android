package com.mpersand.presentation.view.restrict

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mpersand.gymi_components.theme.GYMITheme

@Composable
fun ReportListScreen(
    modifier: Modifier = Modifier,
    nameList: List<String>,
    reportReasonList: List<String>,
    onClicked: () -> Unit
) {
    Column(modifier = modifier.padding(horizontal = 20.dp)) {
        Spacer(modifier = Modifier.height(35.dp))
        Text(
            text = "제재 내역",
            style = GYMITheme.typography.h4,
            color = GYMITheme.colors.bw
        )
        Spacer(modifier = Modifier.height(25.dp))
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(nameList.size) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp)
                        .background(
                            color = GYMITheme.colors.n5,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 16.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) { onClicked },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = nameList[it],
                        style = GYMITheme.typography.h5,
                        color = GYMITheme.colors.bw
                    )
                    Text(
                        text = reportReasonList[it],
                        style = GYMITheme.typography.body3,
                        color = GYMITheme.colors.n2
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}

@Preview
@Composable
fun ReportListScreenPreview() {
    val nameList = listOf("3208 박성현", "1409 박성현", "2210 박성현", "박성현", "3208 박성현", "1409 박성현", "2210 박성현", "박성현", "3208 박성현", "1409 박성현", "2210 박성현", "박성현")
    val reportReasonList = listOf("무단 사용", "지각", "복장 불량", "물품 미반납", "음식물 반입", "기타", "물품 미반납", "무단 사용", "무단 사용", "지각", "복장 불량", "물품 미반납")

    ReportListScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(GYMITheme.colors.bg),
        nameList = nameList,
        reportReasonList = reportReasonList
    ) {}
}