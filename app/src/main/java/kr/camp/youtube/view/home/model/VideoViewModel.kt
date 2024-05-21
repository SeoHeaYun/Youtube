package kr.camp.youtube.view.home.model

import androidx.lifecycle.ViewModel
import kr.camp.youtube.domain.usecase.CategoriesUseCase
import kr.camp.youtube.domain.usecase.ChannelsUseCase
import kr.camp.youtube.domain.usecase.VideoUseCase

class VideoViewModel(
    private val videoUseCase: VideoUseCase,
) : ViewModel() {

}





/*class SearchViewModel(
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
                    SearchUiState.ResultList(items)
                }
            }
        }.onFailure { throwable ->
            _uiState.update {
                when (throwable) {
                    is QuotaExceededException -> SearchUiState.QuotaExceeded
                    is TimeoutException -> SearchUiState.Timeout
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

 */