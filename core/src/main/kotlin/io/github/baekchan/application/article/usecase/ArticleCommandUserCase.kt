package io.github.baekchan.application.article.usecase

import io.github.baekchan.domain.article.entity.ArticleDomain
import io.github.baekchan.domain.article.entity.ArticleId


interface ArticleCommandUserCase {

    fun register(article: ArticleDomain): ArticleId

    fun update(article: ArticleDomain)

    fun delete(articleId: ArticleId)
}