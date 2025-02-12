package io.github.baekchan.framework.user.repository

import io.github.baekchan.framework.user.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<UserEntity, Long> {

    fun findByEmail(email: String): UserEntity?

    fun findByUsername(username: String): UserEntity?
}