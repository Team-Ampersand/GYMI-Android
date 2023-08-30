package com.mpersand.presentation.view.report.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mpersand.gymi_components.component.item.GYMINoticeItem
import com.mpersand.gymi_components.theme.GYMITheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun ReportListScreen(
    modifier: Modifier = Modifier,
    courtList: ImmutableList<String>,
    reportReasonList: ImmutableList<String>,
    dateList: ImmutableList<String>,
    contentList: ImmutableList<String>
) {
    Column(modifier = modifier.padding(horizontal = 20.dp)) {
        Spacer(modifier = Modifier.height(35.dp))
        Text(
            text = "신고 내역",
            style = GYMITheme.typography.h4,
            color = GYMITheme.colors.bw
        )
        Spacer(modifier = Modifier.height(25.dp))
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(courtList.size) {
                GYMINoticeItem(
                    title = "${courtList[it]}번 코트 | ${reportReasonList[it]}",
                    content = contentList[it],
                    date = dateList[it]
                )
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}

@Preview
@Composable
fun ReportListScreenPreview() {
    val courtList = listOf("1", "1", "3", "2", "4", "2", "3", "1").toImmutableList()
    val reportReasonList = listOf("무단 사용", "지각", "복장 불량", "물품 미반납", "음식물 반입", "기타", "물품 미반납", "무단 사용").toImmutableList()
    val dateList = listOf("2023.08.30", "2023.08.20", "2023.08.31", "2023.08.28", "2023.08.23", "2023.08.29", "2023.08.10", "2023.08.30",).toImmutableList()
    val contentList = listOf("1번 코트에서 --이가 무단으로 코트를 사용했습니다.", "1번 코트에서 --이가 지각을 했습니다.", "3번 코트에서 --이가 복장 불량 입니다.", "2번 코트에서 --이가 배드민턴 라켓을 반납하지 않았습니다", "4번 코트에서 --이가 음식물을 반입했습니다.", "2번 코트에서 --이가 폭력을 행사했습니다.", "3번 코트에서 --이가 농구공을 반납하지 않았습니다..", "1번 코트에서 --이가 무단으로 코트를 사용했습니다.",).toImmutableList()

    ReportListScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(GYMITheme.colors.bg),
        courtList = courtList,
        reportReasonList = reportReasonList,
        dateList = dateList,
        contentList = contentList
    )
}
