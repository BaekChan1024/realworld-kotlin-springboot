package io.github.baekchan.application.article.port.out

import io.github.baekchan.domain.article.entity.ArticleDomain
import io.github.baekchan.domain.article.entity.ArticleId

interface ArticleCommandOutPort {

    fun save(article: ArticleDomain): ArticleId

    fun update(article: ArticleDomain)

    fun delete(articleId: ArticleId)
}