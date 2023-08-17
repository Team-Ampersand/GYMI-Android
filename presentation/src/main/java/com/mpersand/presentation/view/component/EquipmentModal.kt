package com.mpersand.presentation.view.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.mpersand.gymi_components.component.button.GYMIButton
import com.mpersand.gymi_components.component.dialog.GYMIDialog
import com.mpersand.gymi_components.theme.Black
import com.mpersand.gymi_components.theme.GYMITheme
import com.mpersand.gymi_components.theme.IcXMark

enum class EquipmentButtonType {
    Rental, Return
}

@Composable
fun EquipmentModal(
    equipmentName: String,
    imageUrl: String,
    description: String,
    buttonType: EquipmentButtonType,
    onButtonClick: () -> Unit,
    onDismissRequest: () -> Unit
) {
    val buttonText = when (buttonType) {
        EquipmentButtonType.Rental -> "대여신청"
        EquipmentButtonType.Return -> "반납하기"
    }

    val buttonColor = when (buttonType) {
        EquipmentButtonType.Rental -> GYMITheme.colors.p1
        EquipmentButtonType.Return -> GYMITheme.colors.p3
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
                text = equipmentName,
                style = GYMITheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                modifier = Modifier
                    .height(130.dp)
                    .clip(RoundedCornerShape(8.dp)),
                painter = rememberAsyncImagePainter(model = imageUrl),
                contentDescription = "equipment image"
            )
            Divider(
                modifier = Modifier.padding(vertical = 16.dp),
                color = Black,
                thickness = 1.dp,
            )
            Text(
                text = description,
                style = GYMITheme.typography.body3,
                lineHeight = 22.sp
            )
            Spacer(modifier = Modifier.height(35.dp))
            GYMIButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp),
                text = buttonText,
                style = GYMITheme.typography.subtitle3,
                backgroundColor = buttonColor
            ) {
                onButtonClick()
            }
        }
    }
}