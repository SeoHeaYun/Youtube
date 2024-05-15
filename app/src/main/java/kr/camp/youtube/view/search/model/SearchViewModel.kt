package kr.camp.youtube.view.search.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kr.camp.youtube.domain.model.SearchEntity
import kr.camp.youtube.domain.usecase.SearchUseCase
import kr.camp.youtube.view.search.state.SearchListUiState
import kr.camp.youtube.view.search.state.item.SearchListItem

class SearchViewModel(
    private val searchUseCase: SearchUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<SearchListUiState> = MutableStateFlow(SearchListUiState())
    val uiState: StateFlow<SearchListUiState> get() = _uiState.asStateFlow()

    fun onSearch(query: String) = viewModelScope.launch {
        val searchEntity = searchUseCase(query)
        val items = createSearchListItems(searchEntity)
        _uiState.update { prevUiState ->
            prevUiState.copy(
                items = items
            )
        }
    }

    private fun createSearchListItems(entity: SearchEntity): List<SearchListItem> {
        return entity.items.map {
            val snippet = it.snippet
            SearchListItem.ImageItem(
                snippet.thumbnails.high.url,
                snippet.title,
                snippet.channelTitle
            )
        }
    }
}