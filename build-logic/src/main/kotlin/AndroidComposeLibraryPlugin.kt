import com.android.build.gradle.LibraryExtension
import ext.alias
import ext.getBundle
import ext.getLibrary
import ext.getPlugin
import ext.implementation
import ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidComposeLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.android")
                alias(libs.getPlugin("android.library"))
                alias(libs.getPlugin("compose.compiler"))

                alias(libs.getPlugin("ktlint"))
            }

            extensions.configure<LibraryExtension> {
                configureCommonAndroidSetting(this)
                buildFeatures {
                    compose = true
                }
            }

            dependencies {
                implementation(platform(libs.getLibrary("androidx.compose.bom")))
                implementation(libs.getBundle("androidx.compose"))
            }
        }
    }
}
