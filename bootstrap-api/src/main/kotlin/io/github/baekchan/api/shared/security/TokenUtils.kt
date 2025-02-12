package io.github.baekchan.api.shared.security

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.Claim
import com.auth0.jwt.interfaces.DecodedJWT
import org.springframework.stereotype.Component
import java.util.*

@Component
class TokenUtils(
    val jwtProperties: JwtProperties
) {

    private val algorithm = Algorithm.HMAC256(jwtProperties.key)

    fun generate(
        userDetails: CustomUserDetails,
        additionalClaims: Map<String, Any> = emptyMap()
    ): String {
        val jwtBuilder = JWT.create()
            .withSubject(userDetails.id.toString())
            .withIssuedAt(Date())
            .withExpiresAt(Date(System.currentTimeMillis() + jwtProperties.accessTokenExpiration))

        additionalClaims.forEach { (key, value) ->
            jwtBuilder.withClaim(key, value.toString())
        }

        return jwtBuilder.sign(algorithm)
    }

//    fun isValid(token: String, userDetails: UserDetails): Boolean {
//        val id = extractId(token)
//        return userDetails == id && !isExpired(token)
//    }


    fun extractId(token: String): String? {
        return getAllClaims(token)["sub"]?.asString()
    }

    fun isExpired(token: String): Boolean {
        val expiration = getAllClaims(token)["exp"]?.asDate()
        return expiration?.before(Date()) ?: true
    }

    fun getAllClaims(token: String): Map<String, Claim> {
        val verifier: JWTVerifier = JWT.require(algorithm).build()
        val decodedJWT: DecodedJWT = verifier.verify(token)
        return decodedJWT.claims
    }
}