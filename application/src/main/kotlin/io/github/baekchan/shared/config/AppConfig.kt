package io.github.baekchan.shared.config

import io.github.baekchan.user.config.UserConfig
import org.springframework.context.annotation.Import

@Import(UserConfig::class)
class AppConfig {
}