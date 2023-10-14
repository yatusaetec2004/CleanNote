package com.yts.cleannote.core.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Snackbar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection

@Composable
fun BasicSnackBar(
    message: String,
    isRTL: Boolean = true,
    containerColor: Color = Color.Black
) {
    Snackbar(containerColor = containerColor) {
        CompositionLocalProvider(
            LocalLayoutDirection provides if (isRTL) LayoutDirection.Rtl else LayoutDirection.Ltr
         ) {
            Row {

            }
        }
    }
}