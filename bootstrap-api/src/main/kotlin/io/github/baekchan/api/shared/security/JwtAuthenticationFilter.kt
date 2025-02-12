package io.github.baekchan.api.shared.security

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
    val userDetailsService: CustomUserDetailsService,
    val tokenValidator: TokenUtils
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authHeader: String? = request.getHeader("Authorization")

        if (authHeader.doesNotContainToken()) {
            filterChain.doFilter(request, response)
            return
        }

        val jwtToken = authHeader!!.extractTokenValue()
        val id = tokenValidator.extractId(jwtToken)

        if (id != null && SecurityContextHolder.getContext().authentication == null) {
            val foundUser = userDetailsService.loadUserById(id)
            updateContext(foundUser, request, jwtToken)
//            if (tokenValidator.isValid(jwtToken, foundUser))

            filterChain.doFilter(request, response)
        }
    }

    private fun String?.doesNotContainToken() =
        this == null

    private fun String.extractTokenValue() =
        this.substringAfter("Bearer ")

    private fun updateContext(foundUser: CustomUserDetails, request: HttpServletRequest, accessToken: String) {
        val authToken = UsernamePasswordAuthenticationToken(foundUser, null, foundUser.authorities)
        foundUser.accessToken = accessToken
        WebAuthenticationDetailsSource().buildDetails(request)
        SecurityContextHolder.getContext().authentication = authToken
    }

}