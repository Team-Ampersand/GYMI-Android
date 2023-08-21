package com.mpersand.presentation.view.notice.detail

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import coil.compose.rememberAsyncImagePainter
import com.mpersand.gymi_components.component.navbar.GYMINavBar
import com.mpersand.gymi_components.component.navbar.GYMINavItem
import com.mpersand.gymi_components.theme.GYMITheme
import com.mpersand.gymi_components.theme.IcBackArrow
import com.mpersand.gymi_components.theme.IcDelete
import com.mpersand.gymi_components.theme.IcEdit
import com.mpersand.gymi_components.theme.IcEquipment
import com.mpersand.gymi_components.theme.IcHome
import com.mpersand.gymi_components.theme.IcReservation

@Composable
fun NoticeDetailScreen(
    modifier: Modifier = Modifier,
    writer: String,
    date: String,
    imageUrlList: List<String>,
    navigationNotice: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var selected by remember { mutableStateOf(4) }

    Scaffold(
        scaffoldState = rememberScaffoldState(),
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
        Column(modifier = Modifier.padding(contentPadding)) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(GYMITheme.colors.bg)
                    .padding(horizontal = 20.dp)
            ) {
                Spacer(modifier = Modifier.height(13.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    IcBackArrow(
                        modifier = Modifier
                            .size(18.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            ) { navigationNotice() },
                        tint = GYMITheme.colors.bw
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    IcEdit(
                        modifier = Modifier
                            .size(18.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            ) { navigationNotice() },
                        tint = GYMITheme.colors.bw
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    IcDelete(
                        modifier = Modifier
                            .size(18.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            ) { navigationNotice() },
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
                        text = "제목",
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
                        text = "내용 내용 내용 내용",
                        style = GYMITheme.typography.body3,
                        color = GYMITheme.colors.bw
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
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
            }
        }
    }
}
