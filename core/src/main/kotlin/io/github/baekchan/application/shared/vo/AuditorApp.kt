package io.github.baekchan.application.shared.vo

import java.time.LocalDateTime

data class AuditorApp<T>(
    val value: T,
    val createdAt: LocalDateTime? = null,
    var modifiedAt: LocalDateTime? = null
)
