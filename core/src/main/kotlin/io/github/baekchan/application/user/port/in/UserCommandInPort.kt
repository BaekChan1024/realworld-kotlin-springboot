package io.github.baekchan.application.user.port.`in`

import io.github.baekchan.domain.user.entity.UserDomain
import io.github.baekchan.domain.user.entity.UserId
import io.github.baekchan.application.user.port.out.UserCommandOutPort
import io.github.baekchan.application.user.usecase.UserCommandUseCase
import org.springframework.stereotype.Component

@Component
class UserCommandInPort(val outputPort: UserCommandOutPort): UserCommandUseCase {

    override fun register(user: UserDomain): UserId {
        return outputPort.save(user)
    }

    override fun update(user: UserDomain) {
        outputPort.update(user)
    }

    override fun delete(userId: UserId) {
        TODO("Not yet implemented")
    }
}