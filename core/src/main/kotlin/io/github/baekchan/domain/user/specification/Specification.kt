package io.github.baekchan.domain.user.specification

interface Specification<T> {
    fun isSatisfiedBy(candidate: T): Boolean
    val requireMessage: String

    operator fun invoke(candidate: T): Boolean = isSatisfiedBy(candidate)

    infix fun and(other: Specification<T>): Specification<T> = object : Specification<T> {
        override fun isSatisfiedBy(candidate: T) = this@Specification(candidate) && other(candidate)
        override val requireMessage = "${this@Specification.requireMessage} AND ${other.requireMessage}"
    }
}

fun <T> T.applySpecification(spec: Specification<T>): T {
    require(spec(this)) { spec.requireMessage }
    return this
}
