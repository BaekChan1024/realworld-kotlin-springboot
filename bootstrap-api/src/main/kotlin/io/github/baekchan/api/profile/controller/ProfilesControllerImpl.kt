package io.github.baekchan.api.profile.controller

import com.io.github.framework.api.controller.ProfilesController
import com.io.github.framework.api.controller.models.GetProfileByUsername200Response
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class ProfilesControllerImpl: ProfilesController {

    override fun followUserByUsername(username: String): ResponseEntity<GetProfileByUsername200Response> {
        TODO("Not yet implemented")
    }

    override fun getProfileByUsername(username: String): ResponseEntity<GetProfileByUsername200Response> {
        TODO("Not yet implemented")
    }

    override fun unfollowUserByUsername(username: String): ResponseEntity<GetProfileByUsername200Response> {
        TODO("Not yet implemented")
    }
}