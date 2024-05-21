package kr.camp.youtube.data.remote

import kr.camp.youtube.BuildConfig
import kr.camp.youtube.data.model.VideoCategoriesresponse.VideoCategoriesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoCategoriesDataSource {
    @GET("videoCategories")
    suspend fun getVideoCategories(
        @Query("part") part: String = "snippet",
        @Query("key") apiKey: String = BuildConfig.YOUTUBE_API_KEY
    ): VideoCategoriesResponse
}

