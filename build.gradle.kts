import org.intellij.jewel.workshop.build.patchLafFile
import org.intellij.jewel.workshop.build.patchRegistryFile
import org.jetbrains.intellij.tasks.PrepareSandboxTask
import java.nio.file.Paths

plugins {
    kotlin("jvm") version "1.9.21"
    id("org.jetbrains.intellij") version "1.16.1"
    id("org.jetbrains.compose") version "1.5.11"
}

group = "org.jetbrains.jewel"
version = "1.0-SNAPSHOT"

intellij {
    version = "2023.2.5"
    instrumentCode = false
}

repositories {
    mavenCentral()
    maven("https://packages.jetbrains.team/maven/p/kpm/public")
}

configurations.all {
    exclude("org.jetbrains.compose.material")
}

kotlin {
    sourceSets {
        all {
            languageSettings {
                optIn("org.jetbrains.jewel.foundation.ExperimentalJewelApi")
            }
        }
    }
}

dependencies {
    implementation("org.jetbrains.jewel:jewel-ide-laf-bridge:0.8.1-ij-232")
    implementation("org.jetbrains.jewel:jewel-int-ui-standalone:0.8.1")
    implementation(compose.desktop.currentOs)
}

tasks {
    val enableNewUi by registering {
        dependsOn(prepareSandbox)

        // disable me to enable old ui :)
        onlyIf { true }

        doLast {
            prepareSandbox.registryFile.get().patchRegistryFile()
            prepareSandbox.lafFile.get().patchLafFile()
        }
    }
    runIde {
        dependsOn(enableNewUi)
    }
}

kotlin {
    jvmToolchain(17)

    sourceSets {
        all {
            languageSettings {
                optIn("org.jetbrains.jewel.ExperimentalJewelApi")
                optIn("androidx.compose.ui.ExperimentalComposeUiApi")
            }
        }
    }
}

val TaskProvider<PrepareSandboxTask>.registryFile: Provider<File>
    get() = flatMap { it.configDir }
        .map { Paths.get(it).resolve("early-access-registry.txt").toFile() }

val TaskProvider<PrepareSandboxTask>.lafFile: Provider<File>
    get() = flatMap { it.configDir }
        .map { Paths.get(it).resolve("options/laf.xml").toFile() }
