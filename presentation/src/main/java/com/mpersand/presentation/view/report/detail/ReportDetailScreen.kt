package com.mpersand.presentation.view.report.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.mpersand.gymi_components.component.button.GYMIButton
import com.mpersand.gymi_components.theme.GYMITheme
import com.mpersand.gymi_components.theme.IcBackArrow
import com.mpersand.gymi_components.theme.IcDelete

@Composable
fun ReportDetailScreen(
    modifier: Modifier = Modifier,
    date: String,
    reporter: String,
    court: String,
    reportReason: String,
    content: String,
    imageUrlList: List<String>,
    navigateToReport: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(13.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IcBackArrow(
                modifier = Modifier
                    .size(18.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { navigateToReport() },
                tint = GYMITheme.colors.bw
            )
            IcDelete(
                modifier = Modifier
                    .size(18.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { },
                tint = GYMITheme.colors.error
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .background(
                    color = GYMITheme.colors.n5,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "신고자 : $reporter",
                style = GYMITheme.typography.h5,
                color = GYMITheme.colors.bw
            )
            Text(
                text = date,
                style = GYMITheme.typography.body3,
                color = GYMITheme.colors.n2
            )
        }
        Spacer(modifier = Modifier.height(13.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .background(
                    color = GYMITheme.colors.n5,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 16.dp, vertical = 15.dp),
        ) {
            Text(
                text = "${court}번 코트 | $reportReason",
                style = GYMITheme.typography.body3,
                color = GYMITheme.colors.bw
            )
        }
        Spacer(modifier = Modifier.height(13.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(
                    color = GYMITheme.colors.n5,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 16.dp, vertical = 15.dp),
        ) {
            Text(
                text = content,
                style = GYMITheme.typography.body3,
                color = GYMITheme.colors.bw
            )
        }
        Spacer(modifier = Modifier.height(13.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            imageUrlList.forEach { imageUrl ->
                if (imageUrl == "") {
                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                            .background(
                                color = GYMITheme.colors.n5,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            ) { },
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "이미지가 존재하지 않습니다.",
                            style = GYMITheme.typography.body4,
                            color = GYMITheme.colors.bw
                        )
                    }
                } else {
                    Image(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            ) { },
                        painter = rememberAsyncImagePainter(model = imageUrl),
                        contentDescription = "image"
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        GYMIButton(
            modifier = Modifier.fillMaxWidth(),
            text = "제재하기",
            backgroundColor = GYMITheme.colors.error
        ) { navigateToReport() }
        Spacer(modifier = Modifier.height(15.dp))
    }
}

@Preview
@Composable
fun ReportDetailScreenPreview() {
    val imageList = listOf("", "")

    ReportDetailScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(GYMITheme.colors.bg),
        date = "2023.08.30",
        reporter = "3208 박성현",
        court = "1",
        reportReason = "무단 사용",
        content = "1번 코트를 --이가 무단으로 사용했습니다. 1번 코트를 --이가 무단으로 사용했습니다. 1번 코트를 --이가 무단으로 사용했습니다.",
        imageUrlList = imageList
    ) {}
}