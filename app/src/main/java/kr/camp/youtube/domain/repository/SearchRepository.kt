package kr.camp.youtube.domain.repository

import kr.camp.youtube.data.model.search.SearchResponse

interface SearchRepository {
    suspend fun getSearch(query: String, netPageToken: String? = null): SearchResponse
}



