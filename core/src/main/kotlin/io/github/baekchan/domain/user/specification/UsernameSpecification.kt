package io.github.baekchan.domain.user.specification

object UsernameBlankSpecification : Specification<String> {
    override val requireMessage = "Username cannot be blank"

    override fun isSatisfiedBy(candidate: String) = candidate.isNotBlank()
}