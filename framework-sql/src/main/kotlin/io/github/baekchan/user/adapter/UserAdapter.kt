package io.github.baekchan.user.adapter

import io.github.baekchan.user.adapter.jpa.repository.UserRepository
import io.github.baekchan.user.entity.UserDomain
import io.github.baekchan.user.port.out.UserCommandOutPort
import org.springframework.stereotype.Component

@Component
class UserAdapter(val userRepository: UserRepository): UserCommandOutPort {

    override fun save(user: UserDomain) {
        TODO("Not yet implemented")
    }

    override fun update(user: UserDomain) {
        TODO("Not yet implemented")
    }

    override fun delete(user: UserDomain) {
        TODO("Not yet implemented")
    }
}