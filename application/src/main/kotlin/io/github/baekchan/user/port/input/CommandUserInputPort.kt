package io.github.baekchan.user.port.input

import io.github.baekchan.user.entity.User
import io.github.baekchan.user.port.output.CommandUserOutputPort
import io.github.baekchan.user.usecase.CommandUserUseCase
import org.springframework.stereotype.Component

@Component
class CommandUserInputPort(val outputPort: CommandUserOutputPort): CommandUserUseCase {

    override fun register(user: User) {
        outputPort.save(user)
    }

    override fun update(user: User) {
        TODO("Not yet implemented")
    }

    override fun delete(user: User) {
        TODO("Not yet implemented")
    }
}