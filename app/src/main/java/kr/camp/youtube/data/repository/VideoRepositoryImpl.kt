package kr.camp.youtube.data.repository

import kr.camp.youtube.data.model.VideoResponse.VideoResponse
import kr.camp.youtube.data.remote.VideoDataSource
import kr.camp.youtube.domain.exception.NetworkException
import kr.camp.youtube.domain.exception.QuotaExceededException
import kr.camp.youtube.domain.exception.TimeoutException
import kr.camp.youtube.domain.exception.UnknownException
import kr.camp.youtube.domain.exception.UnknownHttpException
import kr.camp.youtube.domain.repository.VideoRepository
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class VideoRepositoryImpl (
    private val videoDataSource: VideoDataSource
) : VideoRepository{
    override suspend fun getVideo(chart: String, categoryId: String): VideoResponse {
        return try {
            videoDataSource.getVideo(chart,categoryId)
        } catch (e: HttpException) {
            val message = e.message
            throw when (val code = e.code()) {
                403 -> QuotaExceededException(message)
                else -> UnknownHttpException(code, message)
            }
        } catch (e: SocketTimeoutException) {
            throw TimeoutException(e.message)
        } catch (e: UnknownHostException) {
            throw NetworkException(e.message)
        } catch (e: Exception) {
            throw UnknownException(e.message)
        }
    }
}