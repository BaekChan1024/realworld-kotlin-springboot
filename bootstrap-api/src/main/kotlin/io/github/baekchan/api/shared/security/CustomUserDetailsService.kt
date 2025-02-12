package io.github.baekchan.api.shared.security

import io.github.baekchan.domain.user.entity.UserId
import io.github.baekchan.application.user.usecase.UserQueryUseCase
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userQueryUseCase: UserQueryUseCase
) : UserDetailsService {

    fun loadUserById(id: String): CustomUserDetails {
        val user = userQueryUseCase.findById(UserId(id.toLong()))
        return CustomUserDetails(
            id = user.id?.id ?: 1L,
            username = user.username,
            password = user.password,
            authorities = emptyList(),
            email = user.email,
            bio = user.userDetail?.bio,
            image = user.userDetail?.image
        )
    }

    fun loadUserByEmail(email: String): CustomUserDetails {
        val user = userQueryUseCase.findByEmail(email)
        return CustomUserDetails(
            id = user.id?.id ?: 1L,
            username = user.username,
            password = user.password,
            authorities = emptyList(),
            email = user.email,
            bio = user.userDetail?.bio,
            image = user.userDetail?.image
        )
    }

    override fun loadUserByUsername(username: String): CustomUserDetails {
        val user = userQueryUseCase.findByUsername(username)
        return CustomUserDetails(
            id = user.id?.id ?: 1L,
            username = user.username,
            password = user.password,
            authorities = emptyList(),
            email = user.email,
            bio = user.userDetail?.bio,
            image = user.userDetail?.image
        )
    }
}