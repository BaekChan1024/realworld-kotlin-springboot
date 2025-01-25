package io.github.baekchan.user.controller

import com.io.github.framework.api.controller.UserController
import com.io.github.framework.api.controller.models.Login200Response
import com.io.github.framework.api.controller.models.UpdateCurrentUserRequest
import io.github.baekchan.user.usecase.UserCommandUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class UserControllerImpl(val commandUserUseCase: UserCommandUseCase): UserController {

    override fun getCurrentUser(): ResponseEntity<Login200Response> {
        TODO("Not yet implemented")
    }

    override fun updateCurrentUser(body: UpdateCurrentUserRequest): ResponseEntity<Login200Response> {
        TODO("Not yet implemented")
    }
}