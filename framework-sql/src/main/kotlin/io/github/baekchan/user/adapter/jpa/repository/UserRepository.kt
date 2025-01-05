package io.github.baekchan.user.adapter.jpa.repository

import io.github.baekchan.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {
}