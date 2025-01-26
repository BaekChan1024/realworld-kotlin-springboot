package io.github.baekchan.user.port.out

import io.github.baekchan.user.entity.UserDomain
import io.github.baekchan.user.entity.UserId

interface UserCommandOutPort {

    fun save(user: UserDomain): UserId

    fun update(user: UserDomain)

    fun delete(user: UserDomain)
}