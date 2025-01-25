package io.github.baekchan.shared.security

import io.github.baekchan.user.usecase.UserQueryUseCase
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userQueryUseCase: UserQueryUseCase
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userQueryUseCase.findByEmail(username)
        return User.builder()
            .username(user.username)
            .password(user.password)
            .build()
    }
}