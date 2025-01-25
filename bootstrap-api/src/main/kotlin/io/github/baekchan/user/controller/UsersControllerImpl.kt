package io.github.baekchan.user.controller

import com.io.github.framework.api.controller.UsersController
import com.io.github.framework.api.controller.models.CreateUserRequest
import com.io.github.framework.api.controller.models.Login200Response
import com.io.github.framework.api.controller.models.LoginRequest
import io.github.baekchan.shared.security.AuthenticationService
import io.github.baekchan.user.entity.UserDomain
import io.github.baekchan.user.usecase.UserCommandUseCase
import io.github.baekchan.user.usecase.UserQueryUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersControllerImpl(
    val userCommandUseCase: UserCommandUseCase,
    val userQueryUseCase: UserQueryUseCase,
    val authenticationService: AuthenticationService
): UsersController {

    override fun createUser(body: CreateUserRequest): ResponseEntity<Login200Response> {
        val userDomain = UserDomain(
            email = body.user.email,
            username = body.user.username,
            password = body.user.password,
        )
        userCommandUseCase.register(userDomain)
    }

    override fun login(body: LoginRequest): ResponseEntity<Login200Response> {
        authenticationService.authenticateAndGenerateToken(body.user.email, body.user.password)
    }
}