package kr.camp.youtube.domain.usecase

import kr.camp.youtube.domain.mapper.toEntity
import kr.camp.youtube.domain.model.VideoEntity.VideoEntity
import kr.camp.youtube.domain.repository.VideoRepository

class VideoUseCase (
    private val videoRepository: VideoRepository
) {
    suspend fun getCategoryPopularVideo(chart: String, categoryId: String): Result<VideoEntity> {
        return runCatching {
            videoRepository.getCategoryPopularVideo(chart,categoryId).toEntity()
        }
    }
    suspend fun getMostPopularVideo(chart: String): Result<VideoEntity> {
        return runCatching {
            videoRepository.getMostPopularVideo(chart).toEntity()
        }
    }

}




