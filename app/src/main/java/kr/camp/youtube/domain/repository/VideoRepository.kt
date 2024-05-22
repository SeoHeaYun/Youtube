package kr.camp.youtube.domain.repository

import kr.camp.youtube.data.model.video.VideoResponce


interface VideoRepository {

    suspend fun getCategoryPopularVideo(chart: String, categoryId: String): VideoResponce

    suspend fun getMostPopularVideo(chart: String): VideoResponce

}