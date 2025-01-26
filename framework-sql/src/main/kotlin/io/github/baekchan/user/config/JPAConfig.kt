package io.github.baekchan.user.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(
    basePackages = ["io.github.baekchan.user.repository"],
)
//@EntityScan
class JPAConfig {
}