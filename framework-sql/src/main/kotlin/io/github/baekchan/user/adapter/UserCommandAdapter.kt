package io.github.baekchan.user.adapter

import io.github.baekchan.user.repository.UserRepository
import io.github.baekchan.user.entity.UserDomain
import io.github.baekchan.user.entity.UserEntity
import io.github.baekchan.user.entity.UserId
import io.github.baekchan.user.port.out.UserCommandOutPort
import org.springframework.stereotype.Component

@Component
class UserCommandAdapter(val userRepository: UserRepository): UserCommandOutPort {

    override fun save(user: UserDomain): UserId {
        return UserId(userRepository.save(UserEntity(
            email = user.email,
            password = user.password,
            username = user.username,
        )).id)
    }

    override fun update(user: UserDomain) {
        TODO("Not yet implemented")
    }

    override fun delete(user: UserDomain) {
        TODO("Not yet implemented")
    }
}