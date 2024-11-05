// build.gradle.kts (a nivel de proyecto)
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    // Agrega el plugin de Google Services
    id("com.google.gms.google-services") version "4.3.15" apply false
}


