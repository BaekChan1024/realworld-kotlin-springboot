package io.github.baekchan.article.controller

import com.io.github.framework.api.controller.ArticlesController
import com.io.github.framework.api.controller.models.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class ArticlesControllerImpl: ArticlesController {

    override fun createArticle(article: CreateArticleRequest): ResponseEntity<CreateArticle201Response> {
        TODO("Not yet implemented")
    }

    override fun createArticleComment(
        slug: String,
        comment: CreateArticleCommentRequest
    ): ResponseEntity<CreateArticleComment200Response> {
        TODO("Not yet implemented")
    }

    override fun createArticleFavorite(slug: String): ResponseEntity<CreateArticle201Response> {
        TODO("Not yet implemented")
    }

    override fun deleteArticle(slug: String): ResponseEntity<Unit> {
        TODO("Not yet implemented")
    }

    override fun deleteArticleComment(slug: String, id: Int): ResponseEntity<Unit> {
        TODO("Not yet implemented")
    }

    override fun deleteArticleFavorite(slug: String): ResponseEntity<CreateArticle201Response> {
        TODO("Not yet implemented")
    }

    override fun getArticle(slug: String): ResponseEntity<CreateArticle201Response> {
        TODO("Not yet implemented")
    }

    override fun getArticleComments(slug: String): ResponseEntity<GetArticleComments200Response> {
        TODO("Not yet implemented")
    }

    override fun getArticles(
        tag: String?,
        author: String?,
        favorited: String?,
        offset: Int?,
        limit: Int
    ): ResponseEntity<GetArticlesFeed200Response> {
        TODO("Not yet implemented")
    }

    override fun getArticlesFeed(offset: Int?, limit: Int): ResponseEntity<GetArticlesFeed200Response> {
        TODO("Not yet implemented")
    }

    override fun updateArticle(slug: String, article: UpdateArticleRequest): ResponseEntity<CreateArticle201Response> {
        TODO("Not yet implemented")
    }
}