plugins {
    kotlin("jvm") version "1.9.10"
    id("org.jetbrains.intellij") version "1.16.0"
    id("org.jetbrains.compose") version "1.5.10-beta02"
}

group = "org.jetbrains.jewel"
version = "1.0-SNAPSHOT"

intellij {
    version = "2023.2.3"
    instrumentCode = false
}

repositories {
    mavenCentral()
    maven("https://packages.jetbrains.team/maven/p/kpm/public")
}

configurations.all {
    exclude("org.jetbrains.compose.material")
}

dependencies {
    implementation("org.jetbrains.jewel:jewel-ide-laf-bridge:0.7.3-ij-232")
    implementation(compose.desktop.linux_x64)
    implementation(compose.desktop.linux_arm64)
    implementation(compose.desktop.macos_x64)
    implementation(compose.desktop.macos_arm64)
    implementation(compose.desktop.windows_x64)
}

tasks.test {
    useJUnitPlatform()
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