package io.github.baekchan.user.vo

data class UserDetail private constructor(
    val bio: String?,
    val image: String?,
) {
    companion object {
        fun create(bio: String? = null, image: String? = null): UserDetail {
            return UserDetail(bio, image)
        }
    }
}
