package kr.camp.youtube.data.repository

import kr.camp.youtube.data.model.ChannelsResponse.ChannelsResponse
import kr.camp.youtube.data.model.VideoResponse.VideoResponse
import kr.camp.youtube.data.remote.ChannelsDataSource
import kr.camp.youtube.data.remote.VideoDataSource
import kr.camp.youtube.domain.exception.NetworkException
import kr.camp.youtube.domain.exception.QuotaExceededException
import kr.camp.youtube.domain.exception.TimeoutException
import kr.camp.youtube.domain.exception.UnknownException
import kr.camp.youtube.domain.exception.UnknownHttpException
import kr.camp.youtube.domain.repository.ChannelsRepository
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ChannelsRepositoryImpl (
    private val channelsDataSource: ChannelsDataSource
) : ChannelsRepository {
    override suspend fun getChannels(id: String): ChannelsResponse {
        return try {
            channelsDataSource.getChannels(id)
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