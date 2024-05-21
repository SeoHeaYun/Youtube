package kr.camp.youtube.domain.usecase

import kr.camp.youtube.data.model.VideoEntity.VideoEntity
import kr.camp.youtube.domain.mapper.toEntity
import kr.camp.youtube.domain.model.SearchEntity
import kr.camp.youtube.domain.repository.SearchRepository
import kr.camp.youtube.domain.repository.VideoRepository

class VideoUseCase (
    private val videoRepository: VideoRepository
) {
    suspend operator fun invoke(chart: String, categoryId: String): Result<VideoEntity> {
        return runCatching {
            videoRepository.getVideo(chart,categoryId).toEntity()
        }
    }
}





//class SearchUseCase(
//    private val searchRepository: SearchRepository
//) {
//
//    suspend operator fun invoke(query: String): Result<SearchEntity> {
//        return runCatching {
//            searchRepository.getSearch(query).toEntity()
//        }
//    }
//}