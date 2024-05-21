package kr.camp.youtube.data.remote

import kr.camp.youtube.BuildConfig
import kr.camp.youtube.data.model.ChannelsResponse.ChannelsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ChannelsDataSource {
    @GET("channels")
    suspend fun getChannels(
        @Query("id") id: String,
        @Query("maxResults") maxResults: Int = 20,
        @Query("part") part: String = "snippet",
        @Query("key") apiKey: String = BuildConfig.YOUTUBE_API_KEY
    ): ChannelsResponse
}


