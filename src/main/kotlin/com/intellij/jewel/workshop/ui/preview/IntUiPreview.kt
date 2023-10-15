package com.intellij.jewel.workshop.ui.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.jewel.intui.standalone.IntUiTheme

@Composable
fun IntUiPreview(isDark: Boolean, content: @Composable BoxScope.() -> Unit) {
    val themeDefinition = if (isDark) {
        IntUiTheme.darkThemeDefinition()
    } else {
        IntUiTheme.lightThemeDefinition()
    }
    val background = if (isDark) themeDefinition.colorPalette.grey(2) else Color.White
    IntUiTheme(themeDefinition) {
        Box(
            modifier = Modifier
                .background(background)
                .fillMaxSize(),
            content = content
        )
    }
}