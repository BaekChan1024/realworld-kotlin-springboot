package io.github.baekchan.user.adapter

import io.github.baekchan.user.entity.UserDomain
import io.github.baekchan.user.entity.UserId
import io.github.baekchan.user.port.out.UserQueryOutPort
import io.github.baekchan.user.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class UserQueryAdapter(
    private val userRepository: UserRepository
): UserQueryOutPort {

    override fun findByEmail(email: String): UserDomain {
        val userEntity = userRepository.findByEmail(email) ?: throw RuntimeException("exception")
        return UserDomain(
            id = UserId(userEntity.id),
            username = userEntity.username,
            password = userEntity.password,
            email = userEntity.email,
        )
    }

    override fun findById(id: UserId): UserDomain {
        val userEntity = userRepository.findById(id.id).orElseThrow { RuntimeException("exception") }

        return UserDomain(
            id = UserId(userEntity.id),
            username = userEntity.username,
            password = userEntity.password,
            email = userEntity.email,
        )
    }
}