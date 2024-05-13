package kr.camp.youtube.domain.repository

import kr.camp.youtube.data.model.SearchResponse
import kr.camp.youtube.data.remote.SearchDataSource
import kr.camp.youtube.data.repository.SearchRepository

class SearchRepositoryImpl(
    private val searchDataSource: SearchDataSource
) : SearchRepository {

    override suspend fun getSearch(query: String): SearchResponse {
        return searchDataSource.getSearch(query)
    }
}