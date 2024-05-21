package kr.camp.youtube.view.search.adapter.enums

import kr.camp.youtube.view.search.state.item.SearchItem

enum class SearchViewType {
    SEARCH_RESULT,
    SEARCH_LOADING;

    companion object {
        private val values = entries

        fun findViewTypeByOrdinal(ordinal: Int): SearchViewType? {
            return values.find { it.ordinal == ordinal }
        }

        fun findViewTypeOrdinalBySearchItem(searchItem: SearchItem): Int {
            return when (searchItem) {
                is SearchItem.ImageItem -> SEARCH_RESULT.ordinal
                is SearchItem.LoadingItem -> SEARCH_LOADING.ordinal
            }
        }
    }
}