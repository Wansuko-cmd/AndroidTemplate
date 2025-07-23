import dagger.hilt.android.plugin.HiltExtension
import ext.getLibrary
import ext.implementation
import ext.ksp
import ext.libs
import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.dependencies

class DaggerHiltPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("dagger.hilt.android.plugin")
                apply("com.google.devtools.ksp")
            }


            hilt {
                // https://zenn.dev/kaizuka/articles/831dcad9c0594c
                enableAggregatingTask = false
            }

            dependencies {
                implementation(libs.getLibrary("hilt.android"))
                ksp(libs.getLibrary("hilt.compiler"))
            }
        }
    }
}

fun Project.hilt(configure: Action<HiltExtension>): Unit =
    (this as ExtensionAware).extensions.configure("hilt", configure)
