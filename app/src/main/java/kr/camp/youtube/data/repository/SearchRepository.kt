package kr.camp.youtube.data.repository

import kr.camp.youtube.data.model.SearchResponse

interface SearchRepository {

    suspend fun getSearch(query: String): SearchResponse
}