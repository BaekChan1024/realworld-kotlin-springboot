package io.github.baekchan.user.dto

data class RegisterUserRequest(
    val username: String,
    val email: String,
    val password: String,
)
