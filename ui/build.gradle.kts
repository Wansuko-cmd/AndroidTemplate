plugins {
    alias(projects.plugins.android.compose.library)
    alias(projects.plugins.dagger.hilt)
}

android {
    namespace = "com.template.ui"
}

dependencies {
    implementation(libs.bundles.androidx)

    testImplementation(libs.bundles.test)

    androidTestImplementation(libs.bundles.androidx.test)
}
