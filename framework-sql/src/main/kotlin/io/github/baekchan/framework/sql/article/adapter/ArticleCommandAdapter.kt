package io.github.baekchan.framework.sql.article.adapter

import io.github.baekchan.application.article.port.out.ArticleCommandOutPort
import io.github.baekchan.domain.article.entity.ArticleDomain
import io.github.baekchan.domain.article.entity.ArticleId
import org.springframework.stereotype.Component

@Component
class ArticleCommandAdapter: ArticleCommandOutPort {
    override fun save(article: ArticleDomain): ArticleId {
        TODO("Not yet implemented")
    }

    override fun update(article: ArticleDomain) {
        TODO("Not yet implemented")
    }

    override fun delete(articleId: ArticleId) {
        TODO("Not yet implemented")
    }
}