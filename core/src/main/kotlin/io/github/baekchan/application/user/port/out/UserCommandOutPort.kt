package io.github.baekchan.application.user.port.out

import io.github.baekchan.domain.user.entity.UserDomain
import io.github.baekchan.domain.user.entity.UserId

interface UserCommandOutPort {

    fun save(user: UserDomain): UserId

    fun update(user: UserDomain)

    fun delete(user: UserDomain)
}