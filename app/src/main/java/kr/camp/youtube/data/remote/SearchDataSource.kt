package kr.camp.youtube.data.remote

import kr.camp.youtube.BuildConfig
import kr.camp.youtube.data.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchDataSource {

    @GET("search")
    suspend fun getSearch(
        @Query("q") query: String,
        @Query("maxResults") maxResults: Int = 30,
        @Query("type") type: String = "video",
        @Query("part") part: String = "snippet",
        @Query("key") apiKey: String = BuildConfig.YOUTUBE_API_KEY
    ): SearchResponse
}