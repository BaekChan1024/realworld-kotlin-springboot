package io.github.baekchan.api.shared.security

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
    private val authenticationManager: AuthenticationManager,
    private val customUserDetailsService: CustomUserDetailsService,
    private val tokenUtils: TokenUtils

) {

    fun authenticateAndGenerateToken(email: String, password: String): String {
        val userDetails = customUserDetailsService.loadUserByEmail(email)
        val authenticationToken = UsernamePasswordAuthenticationToken(userDetails.username, password)
        authenticationManager.authenticate(
            authenticationToken
        )
        return tokenUtils.generate(userDetails)
    }

    fun generateToken(id: String, password: String): String {
        val userDetails = customUserDetailsService.loadUserById(id)
        val userDetailsInfo = mapOf(
            "username" to userDetails.username,
            "email" to userDetails.email,
            "bio" to (userDetails.bio?: "Default"),
            "image" to (userDetails.image?: "Default" ),
        )
        return tokenUtils.generate(userDetails, userDetailsInfo)
    }
}