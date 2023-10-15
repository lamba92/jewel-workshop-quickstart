package org.intellij.jewel.workshop.build

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import nl.adaptivity.xmlutil.serialization.XML
import java.io.File

fun File.patchRegistryFile() {
    val registry = readLines()

    val indexOfExperimentalUi = registry.indexOf("ide.experimental.ui")
    val newRegistry = if (indexOfExperimentalUi >= 0) {
        registry.mapIndexed { index, value ->
            if (index == indexOfExperimentalUi + 1) "true" else value
        }
    } else {
        registry + listOf("ide.experimental.ui", "true")
    }
    writeText(newRegistry.joinToString("\n"))
}

val xml = XML {
    indentString = "  "
    defaultPolicy {
        ignoreUnknownChildren()
    }
}

fun File.patchLafFile() {
    val lafSettings = runCatching { xml.decodeFromString<LafSettings>(readText()) }.getOrNull()

    if (lafSettings?.components?.laf?.themeId == LafSettings.LIGHT.components.laf.themeId || lafSettings?.components?.laf?.themeId == LafSettings.DARK.components.laf.themeId) return

    writeText(xml.encodeToString(LafSettings.DARK))
}
