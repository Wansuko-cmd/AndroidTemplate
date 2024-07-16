@file:Suppress("UnstableApiUsage")

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
        create("projects") {
            from(files("../gradle/projects.versions.toml"))
        }
    }
}

rootProject.name = "build-logic"
include(":android")
include(":task")
