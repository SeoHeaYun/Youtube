package kr.camp.youtube.domain.repository

import kr.camp.youtube.data.model.VideoResponse.VideoResponse

interface VideoRepository {

    suspend fun getCategoryPopularVideo(chart: String, categoryId: String): VideoResponse

    suspend fun getMostPopularVideo(chart: String): VideoResponse

}