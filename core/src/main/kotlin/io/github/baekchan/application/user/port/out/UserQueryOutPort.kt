package io.github.baekchan.application.user.port.out

import io.github.baekchan.domain.user.entity.UserDomain
import io.github.baekchan.domain.user.entity.UserId

interface UserQueryOutPort {

    fun findByEmail(email: String): UserDomain

    fun findById(id: UserId): UserDomain

    fun findByUsername(username: String): UserDomain
}