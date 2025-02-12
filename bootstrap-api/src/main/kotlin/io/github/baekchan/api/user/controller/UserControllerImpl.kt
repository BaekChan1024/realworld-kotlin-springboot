package io.github.baekchan.api.user.controller

import com.io.github.framework.api.controller.UserController
import com.io.github.framework.api.controller.models.Login200Response
import com.io.github.framework.api.controller.models.UpdateCurrentUserRequest
import com.io.github.framework.api.controller.models.User
import io.github.baekchan.application.user.usecase.UserCommandUseCase
import io.github.baekchan.application.user.usecase.UserQueryUseCase
import io.github.baekchan.api.shared.security.CustomUserDetails
import io.github.baekchan.domain.user.entity.UserId
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.RestController

@RestController
class UserControllerImpl(
    val commandUserUseCase: UserCommandUseCase,
    val userQueryUseCase: UserQueryUseCase,
    val passwordEncoder: PasswordEncoder
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
        val principal = (SecurityContextHolder.getContext().authentication.principal as CustomUserDetails)
        val request = body.user

        val updatedUser = userQueryUseCase.findById(UserId(principal.id))
            .update(
                email = request.email,
                username = request.username,
                password = passwordEncoder.encode(request.password),
                bio = request.bio,
                image = request.image
            )
        commandUserUseCase.update(updatedUser)
        return ResponseEntity.ok(Login200Response(user = User(
            username = updatedUser.username,
            email = updatedUser.email,
            token = principal.accessToken?:"NaN",
            bio = updatedUser.userDetail?.bio,
            image = updatedUser.userDetail?.image,
        )))

    }
}