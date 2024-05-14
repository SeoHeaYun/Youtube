package kr.camp.youtube.view.search.state

import kr.camp.youtube.view.search.state.item.SearchListItem

data class SearchListUiState(
    val items: List<SearchListItem> = emptyList()
)