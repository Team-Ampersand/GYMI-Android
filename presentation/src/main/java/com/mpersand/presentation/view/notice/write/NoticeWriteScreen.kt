package com.mpersand.presentation.view.notice.write

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import coil.compose.rememberAsyncImagePainter
import com.mpersand.gymi_components.component.button.GYMIButton
import com.mpersand.gymi_components.component.textfield.GYMITextField
import com.mpersand.gymi_components.theme.GYMITheme
import com.mpersand.gymi_components.theme.IcBackArrow

@Composable
fun NoticeWriteScreen(
    modifier: Modifier = Modifier,
    writer: String = "체육선생님",
    date: String = "2023.08.22",
    imageUrlList: List<String> = listOf(),
    navigateToNotice: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    Column(modifier = modifier.padding(horizontal = 20.dp)) {
        Spacer(modifier = Modifier.height(13.dp))
        IcBackArrow(
            modifier = Modifier
                .size(18.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) { navigateToNotice() },
            tint = GYMITheme.colors.bw
        )
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
                text = "작성자 : $writer",
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
        GYMITextField(
            background = GYMITheme.colors.n5,
            value = title,
            textColor = GYMITheme.colors.bw,
            focusColor = GYMITheme.colors.p3,
            placeholder = "제목을 입력해주세요.",
            placeholderColor = GYMITheme.colors.n2,
            horizontalPadding = 0.dp,
            onValueChange = { title = it }
        )
        Spacer(modifier = Modifier.height(13.dp))
        GYMITextField(
            modifier = Modifier.weight(1f),
            background = GYMITheme.colors.n5,
            value = content,
            textColor = GYMITheme.colors.bw,
            focusColor = GYMITheme.colors.p3,
            placeholder = "내용을 입력해주세요.",
            placeholderColor = GYMITheme.colors.n2,
            horizontalPadding = 0.dp,
            onValueChange = { content = it }
        )
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
                            text = "클릭하여 이미지를 넣어주세요.",
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
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            text = "작성하기"
        ) { navigateToNotice() }
        Spacer(modifier = Modifier.height(15.dp))
    }
}

@Preview
@Composable
fun NoticeWriteScreenPreview() {
    var sampleList = mutableListOf("", "")
    NoticeWriteScreen(
        writer = "체육선생님",
        date = "2023.08.22",
        imageUrlList = sampleList
    ) {}
}
