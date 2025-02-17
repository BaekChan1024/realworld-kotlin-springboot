package io.github.baekchan.application.article.port.`in`

import io.github.baekchan.application.article.port.out.ArticleCommandOutPort
import io.github.baekchan.application.article.usecase.ArticleCommandUserCase
import io.github.baekchan.domain.article.entity.ArticleDomain
import io.github.baekchan.domain.article.entity.ArticleId
import org.springframework.stereotype.Component

@Component
class ArticleInPort(
    private val articleCommandOutPort: ArticleCommandOutPort
): ArticleCommandUserCase {

    override fun register(article: ArticleDomain): ArticleId {
        return articleCommandOutPort.save(article)
    }

    override fun update(article: ArticleDomain) {
        TODO("Not yet implemented")
    }

    override fun delete(articleId: ArticleId) {
        TODO("Not yet implemented")
    }
}