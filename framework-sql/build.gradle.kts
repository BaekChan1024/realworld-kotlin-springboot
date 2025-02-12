import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true

dependencies {
    implementation(project(":core"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.mysql:mysql-connector-j:9.1.0")
    implementation ("org.flywaydb:flyway-core:11.2.0")
    implementation("org.flywaydb:flyway-mysql:11.2.0")
}