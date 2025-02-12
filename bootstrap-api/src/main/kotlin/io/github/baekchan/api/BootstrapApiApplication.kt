package io.github.baekchan.api

import io.github.baekchan.application.shared.config.AppConfig
import io.github.baekchan.framework.user.config.JPAConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication(
    scanBasePackageClasses = [BootstrapApiApplication::class]
)
@Import(AppConfig::class, JPAConfig::class)
@ConfigurationPropertiesScan
class BootstrapApiApplication

fun main(args: Array<String>) {
    runApplication<BootstrapApiApplication>(*args)
}
