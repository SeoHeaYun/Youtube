package kr.camp.youtube.view.home.state

sealed interface MostPopularVideoUiState {
    open class Notice(
        val message: String
    ): MostPopularVideoUiState
}


data object MostPopularResultEmpty : MostPopularVideoUiState.Notice("검색 결과 없음")

data object MostPopularQuotaExceeded : MostPopularVideoUiState.Notice("API 사용량 초과")

data object MostPopularTimeout : MostPopularVideoUiState.Notice("API 호출 실패")

data object MostPopularNetwork : MostPopularVideoUiState.Notice("네트워크 오류")

data object MostPopularUnknown : MostPopularVideoUiState.Notice("알 수 없는 오류")



sealed interface MostPopularVideoResultList : MostPopularVideoUiState {
    val mostPopularItems: List<HomeItem.mostPopularItem>

}

data class MostPopularVideoAddList(
    override val mostPopularItems: List<HomeItem.mostPopularItem> = emptyList(),
): MostPopularVideoResultList





