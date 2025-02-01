package io.github.baekchan.user.controller

import com.io.github.framework.api.controller.UserController
import com.io.github.framework.api.controller.models.Login200Response
import com.io.github.framework.api.controller.models.UpdateCurrentUserRequest
import com.io.github.framework.api.controller.models.User
import io.github.baekchan.shared.security.CustomUserDetails
import io.github.baekchan.user.entity.UserDomain
import io.github.baekchan.user.entity.UserId
import io.github.baekchan.user.usecase.UserCommandUseCase
import io.github.baekchan.user.usecase.UserQueryUseCase
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
        val userDomain = userQueryUseCase.findById(UserId(principal.id))
            .let { if (updateUser.email != null) it.changeEmail(updateUser.email) else it }
            .let { if (updateUser.username != null) it.changeUsername(updateUser.username) else it }
            .let { if (updateUser.password != null) it.changePassword(updateUser.password) else it }

//        commandUserUseCase.update()
        TODO()
    }
}