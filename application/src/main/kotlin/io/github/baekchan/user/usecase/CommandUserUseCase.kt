package io.github.baekchan.user.usecase

import io.github.baekchan.user.entity.User

interface CommandUserUseCase {
    fun register(user: User)

    fun update(user: User)

    fun delete(user: User)
}