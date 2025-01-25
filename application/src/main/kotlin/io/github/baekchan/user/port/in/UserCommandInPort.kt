package io.github.baekchan.user.port.`in`

import io.github.baekchan.user.entity.UserDomain
import io.github.baekchan.user.port.out.UserCommandOutPort
import io.github.baekchan.user.usecase.UserCommandUseCase
import org.springframework.stereotype.Component

@Component
class UserCommandInPort(val outputPort: UserCommandOutPort): UserCommandUseCase {

    override fun register(user: UserDomain) {
        outputPort.save(user)
    }

    override fun update(user: UserDomain) {
        TODO("Not yet implemented")
    }

    override fun delete(user: UserDomain) {
        TODO("Not yet implemented")
    }
}