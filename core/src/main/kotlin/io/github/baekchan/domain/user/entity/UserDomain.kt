package io.github.baekchan.domain.user.entity

import io.github.baekchan.domain.user.vo.UserDetail

class UserDomain(
    val id: UserId? = null,
    val email: String,
    val password: String,
    var userDetail: UserDetail
) {

    fun update(
        email: String? = null,
        password: String? = null,
        username: String? = null,
        bio: String? = null,
        image: String? = null
    ): UserDomain {
        return UserDomain(
            email = email ?: this.email,
            password = password ?: this.password,
            userDetail = UserDetail(
                username = username ?: this.userDetail.username ,
                bio = bio ?: this.userDetail.bio,
                image = image ?: this.userDetail.image)
        )
    }


}

data class UserId(val id: Long?)