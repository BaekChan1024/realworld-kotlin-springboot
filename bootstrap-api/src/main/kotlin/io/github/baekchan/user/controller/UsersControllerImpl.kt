package io.github.baekchan.user.controller

import com.io.github.framework.api.controller.UsersController
import com.io.github.framework.api.controller.models.*
import io.github.baekchan.shared.security.AuthenticationService
import io.github.baekchan.user.entity.UserDomain
import io.github.baekchan.user.usecase.UserCommandUseCase
import io.github.baekchan.user.usecase.UserQueryUseCase
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersControllerImpl(
    val userCommandUseCase: UserCommandUseCase,
    val userQueryUseCase: UserQueryUseCase,
    val authenticationService: AuthenticationService,
    val passwordEncoder: PasswordEncoder
) : UsersController {

    override fun createUser(body: CreateUserRequest): ResponseEntity<Login200Response> {
        val userDomain = UserDomain(
            email = body.user.email,
            username = body.user.username,
            password = passwordEncoder.encode(body.user.password),
        )
        val userId = userCommandUseCase.register(userDomain)
        val token = authenticationService.generateToken(userId.id.toString(), userDomain.password)
        return ResponseEntity.ok(
            Login200Response(
                User(
                    email = userDomain.email,
                    token = token,
                    username = userDomain.username,
                    bio = userDomain.userDetail?.bio ?: "Default Bio",
                    image = userDomain.userDetail?.image ?: "Default Image",
                )
            )
        )
    }

    override fun login(body: LoginRequest): ResponseEntity<Login200Response> {
        val token = authenticationService.authenticateAndGenerateToken(
            body.user.email,
            body.user.password
        )
        val userDomain = userQueryUseCase.findByEmail(body.user.email)
        return ResponseEntity.ok(
            Login200Response(
                User(
                    email = userDomain.email,
                    token= token,
                    username = userDomain.username,
                    bio = userDomain.userDetail?.bio ?: "Default Bio",
                    image = userDomain.userDetail?.image ?: "Default Image",
                )
            )
        )
    }
}