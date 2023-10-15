package org.intellij.jewel.workshop.build

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName("application")
data class LafSettings(
    @XmlElement val components: Component
) {
    companion object {
        val DARK = LafSettings(
            Component(
                name = "LafManager",
                autodetect = "true",
                laf = Laf(
                    className = "com.intellij.ide.ui.laf.darcula.DarculaLaf",
                    themeId = "ExperimentalDark"
                )
            )
        )
        val LIGHT = LafSettings(
            Component(
                name = "LafManager",
                autodetect = "true",
                laf = Laf(
                    className = "com.intellij.ide.ui.laf.IntelliJLaf",
                    themeId = "ExperimentalLight"
                )
            )
        )
    }
}

@Serializable
@XmlSerialName("component")
data class Component(
    val name: String,
    val autodetect: String,
    @XmlElement val laf: Laf
)

@Serializable
@XmlSerialName("laf")
data class Laf(
    @SerialName("class-name") val className: String,
    val themeId: String? = null,
)