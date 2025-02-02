package io.github.baekchan.user.entity

import io.github.baekchan.user.specification.EmailAtSpecification
import io.github.baekchan.user.specification.EmailDomainSpecification
import io.github.baekchan.user.specification.UsernameBlankSpecification
import io.github.baekchan.user.specification.applySpecification
import io.github.baekchan.user.vo.UserDetail

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
        val currentDetail = userDetail // ✅ 스마트 캐스트를 위한 임시 변수

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