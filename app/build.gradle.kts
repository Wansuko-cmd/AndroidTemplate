@file:Suppress("UnstableApiUsage")

plugins {
    alias(buildLogic.plugins.android.compose.application)
    alias(libs.plugins.compose.compiler)
    alias(buildLogic.plugins.dagger.hilt)
}

android {
    namespace = "com.template"

    defaultConfig {
        applicationId = "com.template"
        versionCode = 1
        versionName = "0.01"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles.add(getDefaultProguardFile("proguard-android-optimize.txt"))
            proguardFiles.add(file("proguard-rules.pro"))
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.ui)
    implementation(projects.utils)

    implementation(libs.bundles.androidx)
}
