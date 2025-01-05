package io.github.baekchan.user.adapter

import io.github.baekchan.user.adapter.jpa.repository.UserRepository
import io.github.baekchan.user.entity.User
import io.github.baekchan.user.port.output.CommandUserOutputPort
import org.springframework.stereotype.Component

@Component
class UserAdapter(val userRepository: UserRepository): CommandUserOutputPort {

    override fun save(user: User) {
        TODO("Not yet implemented")
    }

    override fun update(user: User) {
        TODO("Not yet implemented")
    }

    override fun delete(user: User) {
        TODO("Not yet implemented")
    }
}