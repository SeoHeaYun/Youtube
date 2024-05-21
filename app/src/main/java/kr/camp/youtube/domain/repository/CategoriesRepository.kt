package kr.camp.youtube.domain.repository
import kr.camp.youtube.data.model.VideoCategoriesresponse.VideoCategoriesResponse

interface CategoriesRepository {
    suspend fun getCategories(): VideoCategoriesResponse

}