package io.github.baekchan.application.article.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["io.github.baekchan.application.article.port.in"])
class ArticleConfig