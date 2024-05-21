package kr.camp.youtube.data.remote

import kr.camp.youtube.BuildConfig
import kr.camp.youtube.data.model.VideoResponse.VideoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoDataSource {
    @GET("videos")
    suspend fun getVideo(
        @Query("chart") chart: String = "mostPopular",
        @Query("videoCategoryId") videoCategoryId: String ,
        @Query("maxResults") maxResults: Int = 20,
        @Query("part") part: String = "snippet",
        @Query("key") apiKey: String = BuildConfig.YOUTUBE_API_KEY
    ): VideoResponse
}




