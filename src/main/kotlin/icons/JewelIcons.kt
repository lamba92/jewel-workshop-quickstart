@file:Suppress("unused", "SameParameterValue")

package icons

import com.intellij.openapi.util.IconLoader

object JewelIcons {

    private fun icon(path: String) = IconLoader.getIcon(path, javaClass)

    @JvmField val ToolWindowIcon = icon("/icons/jewel-tool-window.svg")
}