package com.mpersand.presentation.view.notice.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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

@Composable
fun NoticeListScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(horizontal = 20.dp)) {
        Spacer(modifier = Modifier.height(35.dp))
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
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}

@Preview
@Composable
fun NoticeListScreenPreview() {
    NoticeListScreen()
}