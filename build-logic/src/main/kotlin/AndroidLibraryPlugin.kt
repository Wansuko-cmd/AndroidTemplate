import com.android.build.gradle.LibraryExtension
import ext.alias
import ext.getPlugin
import ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")

                alias(libs.getPlugin("ktlint"))
            }

            extensions.configure<LibraryExtension> {
                configureCommonAndroidSetting(this)
            }
        }
    }
}
