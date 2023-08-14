package com.mpersand.presentation.view.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mpersand.gymi_components.theme.IcGYMILogo
import com.msg.gauthsignin.component.GAuthButton
import com.msg.gauthsignin.component.utils.Types

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.height(210.dp))
        IcGYMILogo(modifier = modifier.size(180.dp))
        Spacer(modifier = modifier.height(50.dp))
        Text(
            text = "GYMI는 교내 체육관 서비스입니다\n에약을 통해 체육관을 이용해 보세요!",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = modifier.weight(1f))
        GAuthButton(
            style = Types.Style.DEFAULT,
            actionType = Types.ActionType.SIGNIN,
            colors = Types.Colors.COLORED,
            horizontalPaddingValue = 63.dp
        ) {

        }
        Spacer(modifier = modifier.height(110.dp))
    }
}