package kr.camp.youtube.data.remote

import kr.camp.youtube.BuildConfig
import kr.camp.youtube.data.model.SearchResponse
import kr.camp.youtube.util.QueryUtil
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchDataSource {

    @GET("search")
    suspend fun getSearch(
        @Query("q") query: String,
        @Query("pageToken") pageToken: String?,
        @Query("maxResults") maxResults: Int = QueryUtil.RESULTS_PER_PAGE,
        @Query("type") type: String = "video",
        @Query("part") part: String = "snippet",
        @Query("key") apiKey: String = BuildConfig.YOUTUBE_API_KEY
    ): SearchResponse
}