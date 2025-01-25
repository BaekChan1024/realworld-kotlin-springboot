package io.github.baekchan.user.usecase

import io.github.baekchan.user.entity.UserDomain

interface UserCommandUseCase {
    fun register(user: UserDomain)

    fun update(user: UserDomain)

    fun delete(user: UserDomain)
}