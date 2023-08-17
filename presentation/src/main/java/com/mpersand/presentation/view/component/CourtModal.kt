package com.mpersand.presentation.view.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.mpersand.gymi_components.component.button.GYMIButton
import com.mpersand.gymi_components.component.dialog.GYMIDialog
import com.mpersand.gymi_components.theme.Black
import com.mpersand.gymi_components.theme.GYMITheme
import com.mpersand.gymi_components.theme.IcXMark

enum class CourtButtonType {
    Cancel, Report
}

@Composable
fun CourtModal(
    courtName: String,
    imageUrl: String,
    personnel: String,
    description: String,
    buttonType: CourtButtonType,
    onButtonClick: () -> Unit,
    onDismissRequest: () -> Unit
) {
    val buttonText = when (buttonType) {
        CourtButtonType.Cancel -> "예약 취소하기"
        CourtButtonType.Report -> "신고하기"
    }

    val buttonColor = when (buttonType) {
        CourtButtonType.Cancel -> GYMITheme.colors.p3
        CourtButtonType.Report -> GYMITheme.colors.error
    }

    GYMIDialog(onDismissRequest = onDismissRequest) {
        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 18.dp)) {
            IcXMark(
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable { onDismissRequest() },
                tint = Black
            )
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = courtName,
                style = GYMITheme.typography.subtitle2
            )
            Image(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .height(130.dp),
                painter = rememberAsyncImagePainter(model = imageUrl),
                contentDescription = "court image"
            )
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                modifier = Modifier.padding(vertical = 10.dp),
                text = "인원",
                style = GYMITheme.typography.subtitle2
            )
            Text(
                text = personnel,
                style = GYMITheme.typography.body2
            )
            Divider(
                modifier = Modifier.padding(vertical = 5.dp),
                color = Black,
                thickness = 1.dp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = description,
                style = GYMITheme.typography.body3,
                lineHeight = 22.sp
            )
            GYMIButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp),
                text = buttonText,
                backgroundColor = buttonColor,
                style = GYMITheme.typography.subtitle3,
                onClick = onButtonClick
            )
        }
    }
}