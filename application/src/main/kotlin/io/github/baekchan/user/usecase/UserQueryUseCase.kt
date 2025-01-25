package io.github.baekchan.user.usecase

import io.github.baekchan.user.entity.UserDomain

interface UserQueryUseCase {

    fun findByEmail(email: String): UserDomain
}