package io.github.baekchan.framework.user.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(
    basePackages = ["io.github.baekchan.framework.user.repository"],
)
@ComponentScan(basePackages = ["io.github.baekchan.framework.user.adapter"])
@EntityScan(basePackages = ["io.github.baekchan.framework.user.entity"])
class JPAConfig {
}