package io.github.baekchan.shared.security

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
    private val authenticationManager: AuthenticationManager,
    private val customUserDetailsService: CustomUserDetailsService,
    private val tokenUtils: TokenUtils

) {

    fun authenticateAndGenerateToken(username: String, password: String): String {
        val authenticationToken = UsernamePasswordAuthenticationToken(username, password)
        authenticationManager.authenticate(
            authenticationToken
        )
        val userDetails = customUserDetailsService.loadUserByUsername(username)
        return tokenUtils.generate(userDetails)
    }

    fun generateToken(email: String, password: String): String {
        val userDetails = customUserDetailsService.loadUserByUsername(email)
        return tokenUtils.generate(userDetails)
    }
}