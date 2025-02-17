package io.github.baekchan.domain.article.entity

data class ArticleDomain(
    val id: ArticleId,
    val title: String,
    val description: String,
    val body: String,
    val favorited: Boolean = false,
    val favoritesCount: Int = 0,
    val tags: List<TagDomain>,
)



data class ArticleId(val id: Long)