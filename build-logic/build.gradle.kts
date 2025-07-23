plugins {
    `kotlin-dsl`
    alias(libs.plugins.ktlint)
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
            id = "com.template.compose.application"
            implementationClass = "AndroidComposeApplicationPlugin"
        }
        register("androidComposeLibrary") {
            id = "com.template.compose.library"
            implementationClass = "AndroidComposeLibraryPlugin"
        }
        register("androidLibrary") {
            id = "com.template.library"
            implementationClass = "AndroidLibraryPlugin"
        }
        register("daggerHilt") {
            id = "com.template.dagger-hilt"
            implementationClass = "DaggerHiltPlugin"
        }
    }
}
