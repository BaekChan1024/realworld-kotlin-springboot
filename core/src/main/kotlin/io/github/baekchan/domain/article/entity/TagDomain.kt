package io.github.baekchan.domain.article.entity

data class TagDomain(
    val id: TagId,
    val name: String
)

data class TagId(val id: Long)