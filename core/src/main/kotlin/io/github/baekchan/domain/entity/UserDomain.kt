package io.github.baekchan.domain.entity

import io.github.baekchan.domain.specification.EmailAtSpecification
import io.github.baekchan.domain.specification.EmailDomainSpecification
import io.github.baekchan.domain.specification.UsernameBlankSpecification
import io.github.baekchan.domain.specification.applySpecification
import io.github.baekchan.domain.vo.UserDetail

data class UserDomain (
    val id : UserId? = null,
    val email: String,
    val username: String,
    val password: String,
    var userDetail: UserDetail? = null
) {

    fun update(
        email: String? = null,
        username: String? = null,
        password: String? = null,
        bio: String? = null,
        image: String? = null
    ): UserDomain {
        val currentDetail = userDetail

        return copy(
            email = email?.applySpecification(EmailAtSpecification and EmailDomainSpecification) ?: this.email,
            username = username?.applySpecification(UsernameBlankSpecification) ?: this.username,
            password = password ?: this.password,
            userDetail = if (bio != null || image != null) {
                currentDetail?.copy(
                    bio = bio ?: currentDetail.bio,
                    image = image ?: currentDetail.image
                ) ?: UserDetail(
                    bio = bio ?: "",
                    image = image ?: ""
                )
            } else {
                currentDetail
            }
        )
    }

}

data class UserId(val id: Long?)