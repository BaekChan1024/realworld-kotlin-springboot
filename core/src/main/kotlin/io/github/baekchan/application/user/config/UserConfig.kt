package io.github.baekchan.application.user.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["io.github.baekchan.application.user.port.in"])
class UserConfig