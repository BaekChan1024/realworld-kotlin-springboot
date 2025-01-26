package io.github.baekchan.shared.security

import io.github.baekchan.user.entity.UserId
import io.github.baekchan.user.usecase.UserQueryUseCase
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userQueryUseCase: UserQueryUseCase
) : UserDetailsService {
    override fun loadUserByUsername(id: String): CustomUserDetails {
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
}