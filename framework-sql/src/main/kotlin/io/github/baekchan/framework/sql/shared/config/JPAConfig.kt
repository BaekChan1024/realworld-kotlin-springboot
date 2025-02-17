package io.github.baekchan.framework.sql.shared.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(
    basePackages = ["io.github.baekchan.framework.sql"],
)
@ComponentScan(basePackages = ["io.github.baekchan.framework.sql"])
@EntityScan(basePackages = ["io.github.baekchan.framework.sql"])
class JPAConfig {
}