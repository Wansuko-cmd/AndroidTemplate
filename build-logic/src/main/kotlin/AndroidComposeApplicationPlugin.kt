import com.android.build.api.dsl.ApplicationExtension
import ext.alias
import ext.getBundle
import ext.getLibrary
import ext.getPlugin
import ext.getVersion
import ext.implementation
import ext.libs
import ext.testImplementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidComposeApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")

                alias(libs.getPlugin("ktlint"))
            }

            extensions.configure<ApplicationExtension> {
                configureCommonAndroidSetting(this)
                buildFeatures {
                    compose = true
                }
                composeOptions {
                    kotlinCompilerExtensionVersion = libs.getVersion("androidx-compose-compiler")
                }
            }

            dependencies {
                implementation(platform(libs.getLibrary("androidx.compose.bom")))
                implementation(libs.getBundle("androidx.compose"))
                testImplementation(libs.getBundle("androidx.compose.test"))
            }
        }
    }
}
