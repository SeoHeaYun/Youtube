package kr.camp.youtube.domain.exception

class UnknownHttpException(
    val code: Int?,
    override val message: String?
) : RuntimeException()