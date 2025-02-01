package io.github.baekchan.user.entity

import io.github.baekchan.user.vo.UserDetail

data class UserDomain (
    val id : UserId? = null,
    val email: String,
    val username: String,
    val password: String,
    var userDetail: UserDetail? = null
) {

    fun changeEmail(email: String): UserDomain {
        return this.copy(email = email)
    }


    fun changeUsername(username: String): UserDomain {
        require(username.isNotBlank()) { "Username cannot be empty" }
        return this.copy(username = username)
    }

    fun changePassword(password: String): UserDomain {
        require(password.length >= 6) { "Password must be at least 6 characters long" }
        return this.copy(password = password)
    }

}

data class UserId(val id: Long?)