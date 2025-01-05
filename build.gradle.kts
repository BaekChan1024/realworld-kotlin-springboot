plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.spring") version "2.1.0"
    kotlin("plugin.jpa") version "2.1.0"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.springframework.boot") version "3.4.1"
}

group = "io.github.baekchan"
version = "1.0-SNAPSHOT"


subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "kotlin-kapt")
    apply(plugin = "kotlin-spring")
    apply(plugin = "kotlin-jpa")

    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.springframework.boot")

    repositories {
        gradlePluginPortal()
        mavenCentral()
    }

    dependencies {
//        testImplementation(kotlin("test"))
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    }

    tasks.test {
        useJUnitPlatform()
    }
    kotlin {
        jvmToolchain(21)
    }
}
