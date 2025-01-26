package io.github.baekchan.user.port.`in`

import io.github.baekchan.user.entity.UserDomain
import io.github.baekchan.user.entity.UserId
import io.github.baekchan.user.port.out.UserQueryOutPort
import io.github.baekchan.user.usecase.UserQueryUseCase
import org.springframework.stereotype.Component

@Component
class UserQueryInPort(
    private val userQueryOutPort: UserQueryOutPort
): UserQueryUseCase {

    override fun findByEmail(email: String): UserDomain {
        return userQueryOutPort.findByEmail(email)
    }

    override fun findById(id: UserId): UserDomain {
        return userQueryOutPort.findById(id)
    }
}