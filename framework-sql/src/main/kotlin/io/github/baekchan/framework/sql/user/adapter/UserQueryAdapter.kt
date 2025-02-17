package io.github.baekchan.framework.sql.user.adapter

import io.github.baekchan.domain.user.entity.UserDomain
import io.github.baekchan.domain.user.entity.UserId
import io.github.baekchan.application.user.port.out.UserQueryOutPort
import io.github.baekchan.domain.user.vo.UserDetail
import io.github.baekchan.framework.sql.user.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class UserQueryAdapter(
    private val userRepository: UserRepository
): UserQueryOutPort {

    override fun findByEmail(email: String): UserDomain {
        val userEntity = userRepository.findByEmail(email) ?: throw RuntimeException("exception")
        return UserDomain(
            id = UserId(userEntity.id),
            userDetail = UserDetail(username = userEntity.username),
            password = userEntity.password,
            email = userEntity.email,
        )
    }

    override fun findById(id: UserId): UserDomain {
        val userEntity = userRepository.findById(id.id).orElseThrow { RuntimeException("exception") }

        return UserDomain(
            id = UserId(userEntity.id),
            userDetail = UserDetail(username = userEntity.username),
            password = userEntity.password,
            email = userEntity.email,
        )
    }

    override fun findByUsername(username: String): UserDomain {
        val userEntity = userRepository.findByUsername(username) ?: throw RuntimeException("exception")

        return UserDomain(
            id = UserId(userEntity.id),
            userDetail = UserDetail(username = userEntity.username),
            password = userEntity.password,
            email = userEntity.email,
        )
    }
}