package io.github.baekchan.user.port.out

import io.github.baekchan.user.entity.UserDomain
import io.github.baekchan.user.entity.UserId

interface UserQueryOutPort {

    fun findByEmail(email: String): UserDomain

    fun findById(id: UserId): UserDomain
    fun findByUsername(username: String): UserDomain
}