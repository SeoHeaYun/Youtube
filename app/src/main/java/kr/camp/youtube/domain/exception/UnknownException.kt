package kr.camp.youtube.domain.exception

class UnknownException(
    override val message: String?
) : RuntimeException()