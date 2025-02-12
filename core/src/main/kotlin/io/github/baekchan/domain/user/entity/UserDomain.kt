package io.github.baekchan.domain.user.entity

import io.github.baekchan.domain.user.specification.EmailAtSpecification
import io.github.baekchan.domain.user.specification.EmailDomainSpecification
import io.github.baekchan.domain.user.specification.UsernameBlankSpecification
import io.github.baekchan.domain.user.specification.applySpecification
import io.github.baekchan.domain.user.vo.UserDetail

data class UserDomain (
    val id : UserId? = null,
    val email: String,
    val username: String,
    val password: String,
    var userDetail: UserDetail? = null
) {

    fun update(
        email: String? = null,
        password: String? = null,
        username: String? = null,
        bio: String? = null,
        image: String? = null
    ): UserDomain {
        return this.copy(
            email = email ?: this.email,
            password = password ?: this.password,
            username = username ?: this.username,
            userDetail = UserDetail(bio = bio ?: this.userDetail?.bio, image = image ?: this.userDetail?.image)
        )
    }

}

data class UserId(val id: Long?)