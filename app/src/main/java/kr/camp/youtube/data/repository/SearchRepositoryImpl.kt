package kr.camp.youtube.data.repository

import kr.camp.youtube.data.model.search.SearchResponse
import kr.camp.youtube.data.remote.SearchDataSource
import kr.camp.youtube.domain.repository.SearchRepository
import kr.camp.youtube.domain.exception.NetworkException
import kr.camp.youtube.domain.exception.QuotaExceededException
import kr.camp.youtube.domain.exception.TimeoutException
import kr.camp.youtube.domain.exception.UnknownException
import kr.camp.youtube.domain.exception.UnknownHttpException
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class SearchRepositoryImpl(
    private val searchDataSource: SearchDataSource
) : SearchRepository {
    override suspend fun getSearch(query: String, nextPageToken: String?): SearchResponse {
        return try {
            searchDataSource.getSearch(query, nextPageToken)
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
