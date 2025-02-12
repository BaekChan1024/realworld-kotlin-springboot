package io.github.baekchan.application.user.usecase

import io.github.baekchan.domain.entity.UserDomain
import io.github.baekchan.domain.entity.UserId

interface UserCommandUseCase {
    fun register(user: UserDomain): UserId

    fun update(user: UserDomain)

    fun delete(user: UserDomain)
}