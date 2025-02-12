package io.github.baekchan.framework.user.adapter

import io.github.baekchan.framework.user.repository.UserRepository
import io.github.baekchan.domain.entity.UserDomain
import io.github.baekchan.framework.user.entity.UserEntity
import io.github.baekchan.domain.entity.UserId
import io.github.baekchan.application.user.port.out.UserCommandOutPort
import org.springframework.stereotype.Component

@Component
class UserCommandAdapter(val userRepository: UserRepository): UserCommandOutPort {

    override fun save(user: UserDomain): UserId {
        return UserId(userRepository.save(
            UserEntity(
            email = user.email,
            password = user.password,
            username = user.username,
        )
        ).id)
    }

    override fun update(user: UserDomain) {
        TODO("Not yet implemented")
    }

    override fun delete(user: UserDomain) {
        TODO("Not yet implemented")
    }
}