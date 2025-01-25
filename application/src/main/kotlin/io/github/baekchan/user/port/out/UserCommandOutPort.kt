package io.github.baekchan.user.port.out

import io.github.baekchan.user.entity.UserDomain

interface UserCommandOutPort {

    fun save(user: UserDomain)

    fun update(user: UserDomain)

    fun delete(user: UserDomain)
}