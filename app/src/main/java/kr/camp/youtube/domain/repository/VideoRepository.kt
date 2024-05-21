package kr.camp.youtube.domain.repository

import kr.camp.youtube.data.model.VideoResponse.VideoResponse

interface VideoRepository {
    suspend fun getVideo(chart: String, categoryId: String): VideoResponse
}