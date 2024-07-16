plugins {
    alias(projects.plugins.android.library)
}

android {
    namespace = "com.template.lib"
}

dependencies {
    implementation(project(":utils"))

    implementation(libs.bundles.androidx)
    testImplementation(libs.bundles.test)
}
