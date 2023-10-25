package com.intellij.jewel.workshop.ui.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.jewel.foundation.theme.JewelTheme
import org.jetbrains.jewel.intui.standalone.theme.darkThemeDefinition
import org.jetbrains.jewel.intui.standalone.theme.lightThemeDefinition

@Composable
fun IntUiPreview(isDark: Boolean, content: @Composable BoxScope.() -> Unit) {
    val themeDefinition = if (isDark) {
        JewelTheme.darkThemeDefinition()
    } else {
        JewelTheme.lightThemeDefinition()
    }
    val background = if (isDark) themeDefinition.colorPalette.grey(2) else Color.White
    JewelTheme(themeDefinition) {
        Box(
            modifier = Modifier
                .background(background)
                .fillMaxSize(),
            content = content
        )
    }
}