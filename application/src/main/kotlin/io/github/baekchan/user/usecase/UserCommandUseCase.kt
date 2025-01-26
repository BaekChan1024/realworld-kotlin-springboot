package io.github.baekchan.user.usecase

import io.github.baekchan.user.entity.UserDomain
import io.github.baekchan.user.entity.UserId

interface UserCommandUseCase {
    fun register(user: UserDomain): UserId

    fun update(user: UserDomain)

    fun delete(user: UserDomain)
}