package io.github.baekchan.application.user.port.`in`

import io.github.baekchan.domain.entity.UserDomain
import io.github.baekchan.domain.entity.UserId
import io.github.baekchan.application.user.port.out.UserQueryOutPort
import io.github.baekchan.application.user.usecase.UserQueryUseCase
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

    override fun findByUsername(username: String): UserDomain {
        return userQueryOutPort.findByUsername(username)
    }
}