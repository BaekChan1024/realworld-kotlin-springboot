package io.github.baekchan.user.entity

import io.github.baekchan.user.vo.UserDetail

class UserDomain (
    val id : UserId? = null,
    val email: String,
    val username: String,
    val password: String,
    var userDetail: UserDetail? = null
) {

}

data class UserId(val id: Long?)