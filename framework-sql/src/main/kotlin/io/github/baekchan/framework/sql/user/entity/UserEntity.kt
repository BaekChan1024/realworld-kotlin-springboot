package io.github.baekchan.framework.sql.user.entity

import jakarta.persistence.*

@Entity
@Table(name = "user")
class UserEntity(
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
