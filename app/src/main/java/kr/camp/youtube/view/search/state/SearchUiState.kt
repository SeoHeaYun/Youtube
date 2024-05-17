package kr.camp.youtube.view.search.state

import kr.camp.youtube.view.search.state.item.SearchItem

sealed interface SearchUiState {

    open class Notice(
        val message: String
    ) : SearchUiState

    data object Loading : SearchUiState

    data object ResultEmpty : Notice("검색 결과 없음")

    data object QuotaExceeded : Notice("API 사용량 초과")

    data object Timeout : Notice("API 호출 실패")

    data object Network : Notice("네트워크 오류")

    data object Unknown : Notice("알 수 없는 오류")

    data class ResultList(
        val items: List<SearchItem> = emptyList(),
        val nextPageToken: String? = null
    ) : SearchUiState
}