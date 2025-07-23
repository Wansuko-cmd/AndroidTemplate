plugins {
    alias(buildLogic.plugins.android.compose.library)
    alias(libs.plugins.compose.compiler)
    alias(buildLogic.plugins.dagger.hilt)
}

android {
    namespace = "com.template.ui"
}

dependencies {
    implementation(libs.bundles.androidx)

    testImplementation(libs.bundles.test)

    androidTestImplementation(libs.bundles.androidx.test)
}
