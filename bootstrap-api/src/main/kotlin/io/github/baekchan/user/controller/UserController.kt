package io.github.baekchan.user.controller

import io.github.baekchan.user.dto.RegisterUserRequest
import io.github.baekchan.user.entity.User
import io.github.baekchan.user.usecase.CommandUserUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(val commandUserUseCase: CommandUserUseCase) {

    @PostMapping
    fun register(@RequestBody request: RegisterUserRequest) {
        val user: User = User.create(request.username, request.email, request.password)
        commandUserUseCase.register(user)
    }
}