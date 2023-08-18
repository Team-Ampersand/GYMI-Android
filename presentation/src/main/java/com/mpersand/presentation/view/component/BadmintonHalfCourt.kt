package com.mpersand.presentation.view.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mpersand.gymi_components.component.court.GYMIBadmintonCourt

@Composable
fun ColumnScope.BadmintonHalfCourt(
    modifier: Modifier = Modifier,
    isReserved: Boolean = false,
    onClick: () -> Unit
) {
    repeat(2) {
        GYMIBadmintonCourt(
            modifier = modifier.fillMaxWidth(),
            isReserved = isReserved,
            onClick = onClick
        )
        Spacer(modifier = Modifier.height(2.dp))
    }
}