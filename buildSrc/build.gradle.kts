plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.gradle.kotlin)
    implementation(libs.gradle.android)
    implementation(libs.gradle.hilt)
    implementation(libs.gradle.ksp)
}

gradlePlugin {
    plugins {
        register("androidComposeApplication") {
            id = "com.template.android.compose.application"
            implementationClass = "plugins.android.compose.AndroidComposeApplicationPlugin"
        }
        register("androidComposeLibrary") {
            id = "com.template.android.compose.library"
            implementationClass = "plugins.android.compose.AndroidComposeLibraryPlugin"
        }
        register("androidLibrary") {
            id = "com.template.android.library"
            implementationClass = "plugins.android.AndroidLibraryPlugin"
        }
        register("daggerHilt") {
            id = "com.template.dagger-hilt"
            implementationClass = "plugins.DaggerHiltPlugin"
        }
        register("ktlint") {
            id = "com.template.ktlint"
            implementationClass = "plugins.KtlintPlugin"
        }
    }
}
