import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.openapi.generator") version "7.11.0"
}

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = true
jar.enabled = false

openApiGenerate {
    generatorName.set("kotlin-spring")
    library.set("spring-boot")
    inputSpec.set("$projectDir/src/main/resources/openapi.yaml")
    outputDir.set("$buildDir/generated")
    configOptions.set(
        mapOf(
            "dateLibrary" to "java8"
        )
    )
    additionalProperties.set(
        mapOf(
            "groupId" to "com.io.github",
            "artifactId" to "store",
            "packageName" to "com.io.github.framework.api.controller",
            "apiPackage" to "com.io.github.framework.api.controller",
            "useSpringBoot3" to "true",
            "useSwaggerUI" to "true",
            "documentationProvider" to "none",
            "apiSuffix" to  "Controller",
            "interfaceOnly" to "true",
            "skipDefaultInterface" to "true",
            "useBeanValidation" to "true",
            "performBeanValidation" to "true",
        )
    )
}

sourceSets {
    main {
        java {
            srcDir("$buildDir/generated/src/main/kotlin")
        }
    }
}

tasks.named("compileKotlin") {
    dependsOn(tasks.named("openApiGenerate"))
}


dependencies {

    implementation(project(":domain"))
    implementation(project(":application"))
    implementation(project(":framework-sql"))

    implementation ("org.springframework.boot:spring-boot-starter-security")
    implementation("com.auth0:java-jwt:4.4.0")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
