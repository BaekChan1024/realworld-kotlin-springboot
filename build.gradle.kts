plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.spring") version "2.1.0" apply false
    kotlin("plugin.jpa") version "2.1.0" apply false
    id("io.spring.dependency-management") version "1.1.7" apply false
    id("org.springframework.boot") version "3.4.1" apply false
}

group = "io.github.baekchan"
version = "1.0-SNAPSHOT"


subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "kotlin-spring")
    apply(plugin = "kotlin-jpa")

    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.springframework.boot")

    repositories {
        gradlePluginPortal()
        mavenCentral()
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter")
        implementation("org.springframework.boot:spring-boot-starter-validation")

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
