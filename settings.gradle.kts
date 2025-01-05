plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        gradlePluginPortal()
    }
}

rootProject.name = "realworld"

include("domain")
include("application")
include("framework-sql")
include("bootstrap-api")
