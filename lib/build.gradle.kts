plugins {
    alias(buildLogic.plugins.android.library)
}

android {
    namespace = "com.template.lib"
}

dependencies {
    implementation(projects.utils)

    implementation(libs.bundles.androidx)
    testImplementation(libs.bundles.test)
}
