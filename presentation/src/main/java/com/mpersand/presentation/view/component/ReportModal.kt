package com.mpersand.presentation.view.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.mpersand.gymi_components.component.button.GYMIButton
import com.mpersand.gymi_components.component.dialog.GYMIDialog
import com.mpersand.gymi_components.component.textfield.GYMITextField
import com.mpersand.gymi_components.theme.Black
import com.mpersand.gymi_components.theme.GYMITheme
import com.mpersand.gymi_components.theme.IcCheckBox
import com.mpersand.gymi_components.theme.IcXMark
import com.mpersand.gymi_components.theme.White

@Composable
fun ReportModal(
    courtName: String,
    onDismissRequest: () -> Unit,
    onReport: (reason: String, detail: String) -> Unit
) {
    var reason by remember { mutableStateOf("") }
    var detail by remember { mutableStateOf("") }

    GYMIDialog(onDismissRequest = onDismissRequest) {
        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 18.dp)) {
            IcXMark(
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable { onDismissRequest() },
                tint = Black
            )
            Row(
                modifier = Modifier.padding(top = 25.dp, bottom = 30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "신고하기",
                    style = GYMITheme.typography.subtitle2
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = courtName,
                    style = GYMITheme.typography.body2,
                    color = GYMITheme.colors.n3
                )
            }
            Text(
                text = "신고사유",
                style = GYMITheme.typography.subtitle3
            )
            Spacer(modifier = Modifier.height(7.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                ReportReasonDropdown(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    reason = it
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "세부사항",
                style = GYMITheme.typography.subtitle3
            )
            Spacer(modifier = Modifier.height(7.dp))
            GYMITextField(
                modifier = Modifier.height(112.dp),
                background = White,
                value = detail,
                textColor = Black,
                border = Color(0xFFD3D3D3),
                focusColor = GYMITheme.colors.p1,
                placeholder = "세부사항을 입력해주세요",
                placeholderColor = GYMITheme.colors.n2,
                horizontalPadding = 0.dp,
            ) {
                detail = it
            }
            Spacer(modifier = Modifier.height(10.dp))
            GYMIButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp),
                text = "신고하기",
                backgroundColor = GYMITheme.colors.error,
                style = GYMITheme.typography.subtitle3,
                contentPadding = 15.dp,
            ) {
                onReport(reason, detail)
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ReportReasonDropdown(
    modifier: Modifier = Modifier,
    selectedReason: (String) -> Unit
) {
    var reason by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    LaunchedEffect(reason) {
        selectedReason(reason)
    }

    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        BasicTextField(
            modifier = modifier
                .border(
                    width = 1.dp,
                    color = if (expanded) GYMITheme.colors.p1 else Color(0xFFD3D3D3),
                    shape = RoundedCornerShape(8.dp)
                ),
            value = reason,
            readOnly = true,
            onValueChange = { reason = it },
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 13.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box {
                        if (reason.isEmpty()) {
                            Text(
                                text = "신고사유를 선택해주세요",
                                style = GYMITheme.typography.body3,
                                color = GYMITheme.colors.n2
                            )
                        }
                        innerTextField()
                    }
                    IcCheckBox(
                        modifier = Modifier.graphicsLayer { if (expanded) rotationX = 180f },
                        tint = GYMITheme.colors.n2
                    )
                }
            }
        )
        val reasons = listOf("무단 사용", "지각", "복장 불량", "물품 미반납", "음식물 반입", "기타")
        ExposedDropdownMenu(
            modifier = Modifier.exposedDropdownSize(),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            reasons.forEach {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(color = GYMITheme.colors.n4),
                        ) {
                            reason = it
                            expanded = false
                        }
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    text = it,
                    style = GYMITheme.typography.body3,
                    color = GYMITheme.colors.n2
                )
            }
        }
    }
}