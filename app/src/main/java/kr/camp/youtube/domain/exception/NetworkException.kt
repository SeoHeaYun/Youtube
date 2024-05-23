package kr.camp.youtube.domain.exception

class NetworkException(
    override val message: String?
) : RuntimeException()