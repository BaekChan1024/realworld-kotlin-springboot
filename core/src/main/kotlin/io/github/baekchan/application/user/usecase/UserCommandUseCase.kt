package io.github.baekchan.application.user.usecase

import io.github.baekchan.domain.user.entity.UserDomain
import io.github.baekchan.domain.user.entity.UserId

interface UserCommandUseCase {
    fun register(user: UserDomain): UserId

    fun update(user: UserDomain)

    fun delete(user: UserId)
}