package io.github.baekchan.user.usecase

import io.github.baekchan.user.entity.UserDomain
import io.github.baekchan.user.entity.UserId

interface UserQueryUseCase {

    fun findByEmail(email: String): UserDomain

    fun findById(id: UserId): UserDomain

    fun findByUsername(username: String): UserDomain
}