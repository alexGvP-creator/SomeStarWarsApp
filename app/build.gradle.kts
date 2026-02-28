plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.koin.compiler)
}

android {
    namespace = "com.example.somestarwarsapp"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.somestarwarsapp"
        minSdk = 33
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.koin.android)
    implementation(libs.koin.compose.navigation3)
    implementation(libs.koin.androidx.compose)
    implementation(libs.navigation3.runtime)
    implementation(libs.material3)
    implementation(libs.navigation3.ui)
    implementation(libs.material.icons.extended)
    implementation(libs.retrofit)
    implementation(libs.kotlinx.serialization.converter)
}
