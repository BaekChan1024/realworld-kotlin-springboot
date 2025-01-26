package io.github.baekchan.user.port.out

import io.github.baekchan.user.entity.UserDomain

interface UserQueryOutPort {

    fun findByEmail(email: String): UserDomain
}