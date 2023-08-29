package com.mpersand.presentation.view.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mpersand.gymi_components.component.button.GYMIButton
import com.mpersand.gymi_components.component.dialog.GYMIDialog
import com.mpersand.gymi_components.component.textfield.GYMITextField
import com.mpersand.gymi_components.theme.Black
import com.mpersand.gymi_components.theme.GYMITheme
import com.mpersand.gymi_components.theme.IcXMark
import com.mpersand.gymi_components.theme.White

@Composable
fun RestrictionModal(
    onDismissRequest: () -> Unit,
    onRestrictionClicked: () -> Unit
) {
    var restrictedDays by remember { mutableStateOf("") }

    GYMIDialog(onDismissRequest = onDismissRequest) {
        Column(modifier = Modifier.padding(horizontal = 21.dp, vertical = 19.dp)) {
            IcXMark(
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = onDismissRequest
                    ),
                tint = GYMITheme.colors.bw
            )
            Text(
                modifier = Modifier.padding(top = 25.dp, bottom = 30.dp),
                text = "제재하기",
                style = GYMITheme.typography.subtitle2,
                color = GYMITheme.colors.bw
            )
            Text(
                text = "제재 일수",
                style = GYMITheme.typography.subtitle3,
                color = GYMITheme.colors.bw
            )
            Spacer(modifier = Modifier.height(7.dp))
            GYMITextField(
                background = White,
                textColor = Black,
                value = restrictedDays,
                border = Color(0xFFD3D3D3),
                placeholder = "제재 일수를 입력해주세요",
                onValueChange = { restrictedDays = it },
            )
            GYMIButton(
                modifier = Modifier
                    .padding(top = 40.dp, bottom = 31.dp)
                    .fillMaxWidth(),
                text = "제재하기",
                backgroundColor = GYMITheme.colors.error,
                onClick = onRestrictionClicked
            )
        }
    }
}