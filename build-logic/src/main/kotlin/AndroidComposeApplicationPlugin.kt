import com.android.build.api.dsl.ApplicationExtension
import ext.alias
import ext.buildLogic
import ext.getBundle
import ext.getLibrary
import ext.getPlugin
import ext.getVersion
import ext.implementation
import ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidComposeApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.android")
                alias(libs.getPlugin("android.application"))
                alias(libs.getPlugin("compose.compiler"))

                alias(libs.getPlugin("ktlint"))
            }

            extensions.configure<ApplicationExtension> {
                configureCommonAndroidSetting(this)
                defaultConfig {
                    targetSdk = buildLogic.getVersion("android.targetSdk").toInt()
                }
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
