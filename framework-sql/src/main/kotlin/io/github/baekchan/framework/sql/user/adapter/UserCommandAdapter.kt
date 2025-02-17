package io.github.baekchan.framework.sql.user.adapter

import io.github.baekchan.framework.sql.user.repository.UserRepository
import io.github.baekchan.domain.user.entity.UserDomain
import io.github.baekchan.framework.sql.user.entity.UserEntity
import io.github.baekchan.domain.user.entity.UserId
import io.github.baekchan.application.user.port.out.UserCommandOutPort
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserCommandAdapter(val userRepository: UserRepository): UserCommandOutPort {

    override fun save(user: UserDomain): UserId {
        return UserId(userRepository.save(
            UserEntity(
            email = user.email,
            password = user.password,
            username = user.userDetail.username,
        )
        ).id)
    }

    override fun update(user: UserDomain) {
        userRepository.save(
            UserEntity(
                email = user.email,
                password = user.password,
                username = user.userDetail.username,
            )
        )
    }

    override fun delete(userId: UserId) {
        TODO("Not yet implemented")
    }
}