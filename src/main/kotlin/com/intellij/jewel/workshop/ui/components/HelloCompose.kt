package com.intellij.jewel.workshop.ui.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.intellij.jewel.workshop.ui.preview.IntUiPreview
import org.jetbrains.jewel.Text

@Composable
fun HelloCompose() {
    Box(Modifier.padding(8.dp)) {
        Text("Hello Compose!")
    }
}

@Preview
@Composable
fun HelloComposePreview() = IntUiPreview(isDark = true) {
    HelloCompose()
}