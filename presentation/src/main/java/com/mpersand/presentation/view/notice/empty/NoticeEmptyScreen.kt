package com.mpersand.presentation.view.notice.empty

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mpersand.gymi_components.theme.GYMITheme
import com.mpersand.gymi_components.theme.IcNotice

@Composable
fun NoticeEmptyScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
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

@Preview
@Composable
fun NoticeEmptyScreenPreview() {
    NoticeEmptyScreen()
}
