plugins {
    alias(libs.plugins.compose.compiler) apply false
    alias(projects.plugins.ktlint)
}

task<Delete>("clean") {
    delete(rootProject.buildFile)
}

buildscript {
    dependencies {
        classpath(libs.gradle.kotlin)
        classpath(libs.gradle.android)
        classpath(libs.gradle.hilt)
        classpath(libs.gradle.ksp)
    }
}
