package io.github.baekchan.application.shared.config

import io.github.baekchan.application.user.config.UserConfig
import org.springframework.context.annotation.Import

@Import(UserConfig::class)
class AppConfig {
}