package kr.camp.youtube.network

import kr.camp.youtube.data.remote.SearchDataSource
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object YoutubeRetrofitClient {

    private const val YOUTUBE_API_BASE_URL = "https://www.googleapis.com/youtube/v3/"

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(YOUTUBE_API_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val searchDataSource: SearchDataSource by lazy {
        retrofit.create(SearchDataSource::class.java)
    }
}