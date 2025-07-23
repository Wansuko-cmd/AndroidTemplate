package ext

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

val Project.libs: VersionCatalog
    get() = this.extensions.getByType<VersionCatalogsExtension>().named("libs")

val Project.projects: VersionCatalog
    get() = this.extensions.getByType<VersionCatalogsExtension>().named("projects")

fun VersionCatalog.getVersion(alias: String) = findVersion(alias).get().toString()

fun VersionCatalog.getLibrary(alias: String) = findLibrary(alias).get()

fun VersionCatalog.getBundle(alias: String) = findBundle(alias).get()
