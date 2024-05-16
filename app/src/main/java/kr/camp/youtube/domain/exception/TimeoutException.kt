package kr.camp.youtube.domain.exception

class TimeoutException(
    override val message: String?
) : RuntimeException()