package io.github.baekchan.user.entity

import jakarta.persistence.*

@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var email: String,

    @Column(nullable = false)
    var username: String,

    @Column(nullable = false)
    var password: String
)
