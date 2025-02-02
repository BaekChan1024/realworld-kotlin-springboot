package io.github.baekchan.user.specification

object EmailAtSpecification : Specification<String> {

    override val requireMessage = "Email must contain '@'"

    override fun isSatisfiedBy(candidate: String) = candidate.contains("@")
}

object EmailDomainSpecification : Specification<String> {
    override val requireMessage = "Email must end with 'test.com'"

    override fun isSatisfiedBy(candidate: String) = candidate.endsWith("test.com")
}