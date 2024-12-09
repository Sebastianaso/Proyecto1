plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.gms.google-services") // Aplica el plugin de Google Services
}

android {
    namespace = "com.example.recetarioexpress"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.recetarioexpress"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)

    // Agregar Coil para Compose (para cargar imágenes)
    implementation("io.coil-kt:coil-compose:2.1.0")

    // Dependencias adicionales para Material Design en Compose
    implementation("androidx.compose.material:material:1.7.5")
    implementation(libs.androidx.appcompat)

    // Firebase BOM para gestionar las versiones de forma coherente
    implementation(platform("com.google.firebase:firebase-bom:33.7.0")) // Cambia a la última versión disponible

    // Dependencias de Firebase
    implementation("com.google.firebase:firebase-auth-ktx:23.1.0") // Firebase Authentication
    implementation("com.google.firebase:firebase-database-ktx") // Firebase Realtime Database
    implementation("com.google.firebase:firebase-firestore-ktx") // Firebase Firestore

    // Servicios de autenticación de Google
    implementation("com.google.android.gms:play-services-auth:21.2.0") // Usa la versión más reciente disponible

    // Retrofit y convertidor Gson
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
