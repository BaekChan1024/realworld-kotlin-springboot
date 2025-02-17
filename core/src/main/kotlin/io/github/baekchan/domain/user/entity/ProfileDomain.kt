package io.github.baekchan.domain.user.entity

import io.github.baekchan.domain.user.vo.UserDetail

class ProfileDomain(
    val id: ProfileId,
    val userDetail: UserDetail,
    val following: Boolean
) {


}

data class ProfileId(val id: Long)