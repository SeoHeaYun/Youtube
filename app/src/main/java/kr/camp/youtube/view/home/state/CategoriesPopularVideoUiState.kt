package kr.camp.youtube.view.home.state


sealed interface CategoryPopularVideoUiState {
    open class Notice(
        val message: String
    ): CategoryPopularVideoUiState
}


object CategoryPopularResultEmpty : CategoryPopularVideoUiState.Notice("검색 결과 없음")

object CategoryPopularQuotaExceeded : CategoryPopularVideoUiState.Notice("API 사용량 초과")

object CategoryPopularTimeout : CategoryPopularVideoUiState.Notice("API 호출 실패")

object CategoryPopularNetwork : CategoryPopularVideoUiState.Notice("네트워크 오류")

object CategoryPopularUnknown : CategoryPopularVideoUiState.Notice("알 수 없는 오류")




sealed interface CategoryPopularResultList : CategoryPopularVideoUiState {

    val categoryPopularItems: List<HomeItem.categoryPopularItem>

}

data class CategoryPopularAddList(
    override val categoryPopularItems: List<HomeItem.categoryPopularItem> = emptyList(),
): CategoryPopularResultList

