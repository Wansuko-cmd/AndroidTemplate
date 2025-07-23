import com.android.build.api.dsl.CommonExtension
import ext.buildLogic
import ext.getVersion
import org.gradle.api.Action
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidExtension

fun Project.configureCommonAndroidSetting(commonExtension: CommonExtension<*, *, *, *, *, *>) {
    commonExtension.apply {
        compileSdk = buildLogic.getVersion("android.compileSdk").toInt()

        defaultConfig {
            minSdk = buildLogic.getVersion("android.minSdk").toInt()
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
}

private fun Project.kotlin(configure: Action<KotlinAndroidExtension>): Unit =
    (this as ExtensionAware).extensions.configure("kotlin", configure)
