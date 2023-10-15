package com.intellij.jewel.workshop

import com.intellij.jewel.workshop.ui.components.HelloCompose
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import org.jetbrains.jewel.bridge.SwingBridgeTheme
import org.jetbrains.jewel.bridge.addComposeTab

class JewelWorkshopToolWindowFactory : ToolWindowFactory, DumbAware {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        toolWindow.addComposeTab("Compose tab") {
            SwingBridgeTheme {
                HelloCompose()
            }
        }
    }
}