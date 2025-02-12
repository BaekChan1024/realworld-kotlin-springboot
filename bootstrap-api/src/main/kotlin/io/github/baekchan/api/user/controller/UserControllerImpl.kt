package io.github.baekchan.api.user.controller

import com.io.github.framework.api.controller.UserController
import com.io.github.framework.api.controller.models.Login200Response
import com.io.github.framework.api.controller.models.UpdateCurrentUserRequest
import com.io.github.framework.api.controller.models.User
import io.github.baekchan.application.user.usecase.UserCommandUseCase
import io.github.baekchan.application.user.usecase.UserQueryUseCase
import io.github.baekchan.api.shared.security.CustomUserDetails
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.RestController

@RestController
class UserControllerImpl(
    val commandUserUseCase: UserCommandUseCase,
    val userQueryUseCase: UserQueryUseCase
) : UserController {

    override fun getCurrentUser(): ResponseEntity<Login200Response> {
        val authentication = SecurityContextHolder.getContext().authentication
        val principal = authentication.principal as CustomUserDetails

        return ResponseEntity.ok(
            Login200Response(
                User(
                    username = principal.username,
                    email = principal.email,
                    bio = principal.bio ?: "Default",
                    image = principal.image ?: "Default",
                    token = principal.accessToken ?: "Default",
                )
            )
        )
    }

    override fun updateCurrentUser(body: UpdateCurrentUserRequest): ResponseEntity<Login200Response> {
        val authentication = SecurityContextHolder.getContext().authentication
        val principal = authentication.principal as CustomUserDetails

        val updateUser = body.user

        TODO()
    }
}