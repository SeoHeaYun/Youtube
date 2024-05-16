package kr.camp.youtube.domain.exception

class QuotaExceededException(
    override val message: String?
) : RuntimeException()