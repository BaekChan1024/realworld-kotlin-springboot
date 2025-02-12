package io.github.baekchan.application.user.port.out

import io.github.baekchan.domain.entity.UserDomain
import io.github.baekchan.domain.entity.UserId

interface UserCommandOutPort {

    fun save(user: UserDomain): UserId

    fun update(user: UserDomain)

    fun delete(user: UserDomain)
}