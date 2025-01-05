package io.github.baekchan.user.entity

import io.github.baekchan.user.vo.UserDetail

class User private constructor(
    private val email: String,
    private val username: String,
    private val password: String,
    private val bio: UserDetail?
) {
    companion object {
        fun create(email: String, username: String, password: String): User {
            return User(email, username, password, null)
        }
    }
}

data class UserId(val id: Long)