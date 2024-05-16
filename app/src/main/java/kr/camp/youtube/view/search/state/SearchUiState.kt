package kr.camp.youtube.view.search.state

import kr.camp.youtube.view.search.state.item.SearchItem

sealed interface SearchUiState {

    data object ResultEmpty : SearchUiState

    data object Loading : SearchUiState

    data object QuotaExceeded : SearchUiState

    data object Network : SearchUiState

    data object Unknown : SearchUiState

    data class Result(
        val items: List<SearchItem> = emptyList()
    ) : SearchUiState
}