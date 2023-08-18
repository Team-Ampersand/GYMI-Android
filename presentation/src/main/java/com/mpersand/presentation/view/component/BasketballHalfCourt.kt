package com.mpersand.presentation.view.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.mpersand.gymi_components.component.court.GYMIBasketballCourt

@Composable
fun ColumnScope.BasketballHalfCourt(
    modifier: Modifier = Modifier,
    isReserved: Boolean = false,
    onClick: () -> Unit
) {
    Row(modifier = modifier) {
        repeat(2) {
            GYMIBasketballCourt(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .graphicsLayer {
                        if (it % 2 != 0) rotationY = 180f
                    },
                isReserved = isReserved,
                onClick = onClick
            )
            Spacer(modifier = Modifier.width(2.dp))
        }
    }
}