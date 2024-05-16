package kr.camp.youtube.view.search.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kr.camp.youtube.domain.exception.NetworkException
import kr.camp.youtube.domain.exception.QuotaExceededException
import kr.camp.youtube.domain.model.SearchEntity
import kr.camp.youtube.domain.usecase.SearchUseCase
import kr.camp.youtube.view.search.state.SearchUiState
import kr.camp.youtube.view.search.state.item.SearchItem

class SearchViewModel(
    private val searchUseCase: SearchUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<SearchUiState> = MutableStateFlow(SearchUiState.ResultEmpty)
    val uiState: StateFlow<SearchUiState> get() = _uiState.asStateFlow()

    fun onSearch(query: String) = viewModelScope.launch {
        setLoading()
        searchUseCase(query).onSuccess { searchEntity ->
            val items = createSearchListItems(searchEntity)
            _uiState.update {
                if (items.isEmpty()) {
                    SearchUiState.ResultEmpty
                } else {
                    SearchUiState.Result(items)
                }
            }
        }.onFailure { throwable ->
            _uiState.update {
                when (throwable) {
                    is QuotaExceededException -> SearchUiState.QuotaExceeded
                    is NetworkException -> SearchUiState.Network
                    else -> SearchUiState.Unknown
                }
            }
        }
    }

    private fun setLoading() {
        _uiState.update {
            SearchUiState.Loading
        }
    }

    private fun createSearchListItems(entity: SearchEntity): List<SearchItem> {
        return entity.items.map {
            val snippet = it.snippet
            SearchItem.ImageItem(
                snippet.thumbnails.high.url,
                snippet.title,
                snippet.channelTitle
            )
        }
    }
}