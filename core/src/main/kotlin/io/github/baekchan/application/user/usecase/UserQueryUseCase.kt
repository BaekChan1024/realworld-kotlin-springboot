package io.github.baekchan.application.user.usecase

import io.github.baekchan.domain.entity.UserDomain
import io.github.baekchan.domain.entity.UserId

interface UserQueryUseCase {

    fun findByEmail(email: String): UserDomain

    fun findById(id: UserId): UserDomain

    fun findByUsername(username: String): UserDomain
}