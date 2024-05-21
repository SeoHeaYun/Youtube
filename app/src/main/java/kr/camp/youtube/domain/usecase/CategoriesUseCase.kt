package kr.camp.youtube.domain.usecase

import kr.camp.youtube.data.model.VideoCategoriesEntity.VideoCategoriesEntity
import kr.camp.youtube.data.repository.CategoriesRepositoryImpl
import kr.camp.youtube.domain.mapper.toEntity

class CategoriesUseCase(
    private val categoriesRepository: CategoriesRepositoryImpl
) {
    suspend operator fun invoke(): Result<VideoCategoriesEntity> {
        return runCatching {
            categoriesRepository.getCategories().toEntity()
        }
    }
}
