package io.github.baekchan.user.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["io.github.baekchan.user.port.input"])
class UserConfig