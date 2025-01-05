package io.github.baekchan.user.port.output

import io.github.baekchan.user.entity.User

interface CommandUserOutputPort {

    fun save(user: User)

    fun update(user: User)

    fun delete(user: User)
}