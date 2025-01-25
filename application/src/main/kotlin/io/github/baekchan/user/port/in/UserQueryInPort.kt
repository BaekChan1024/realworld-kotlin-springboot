package io.github.baekchan.user.port.`in`

import io.github.baekchan.user.entity.UserDomain
import io.github.baekchan.user.usecase.UserQueryUseCase
import org.springframework.stereotype.Component

@Component
class UserQueryInPort(

): UserQueryUseCase {

    override fun findByEmail(email: String): UserDomain {
        TODO("Not yet implemented")
    }
}