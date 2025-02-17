package io.github.baekchan.domain.user.vo

data class UserDetail (
    val username: String,
    val bio: String? = null,
    val image: String? = null,
) {

}
