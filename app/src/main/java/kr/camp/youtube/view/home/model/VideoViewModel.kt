package kr.camp.youtube.view.home.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kr.camp.youtube.domain.exception.NetworkException
import kr.camp.youtube.domain.exception.QuotaExceededException
import kr.camp.youtube.domain.exception.TimeoutException
import kr.camp.youtube.domain.model.video.VideoEntity
import kr.camp.youtube.domain.usecase.VideoUseCase
import kr.camp.youtube.view.home.state.CategoryPopularAddList
import kr.camp.youtube.view.home.state.CategoryPopularNetwork
import kr.camp.youtube.view.home.state.CategoryPopularQuotaExceeded
import kr.camp.youtube.view.home.state.CategoryPopularResultEmpty
import kr.camp.youtube.view.home.state.CategoryPopularTimeout
import kr.camp.youtube.view.home.state.CategoryPopularUnknown
import kr.camp.youtube.view.home.state.CategoryPopularVideoUiState
import kr.camp.youtube.view.home.state.HomeItem
import kr.camp.youtube.view.home.state.MostPopularNetwork
import kr.camp.youtube.view.home.state.MostPopularQuotaExceeded
import kr.camp.youtube.view.home.state.MostPopularResultEmpty
import kr.camp.youtube.view.home.state.MostPopularTimeout
import kr.camp.youtube.view.home.state.MostPopularUnknown
import kr.camp.youtube.view.home.state.MostPopularVideoAddList
import kr.camp.youtube.view.home.state.MostPopularVideoUiState



class VideoViewModel(
    private val videoUseCase: VideoUseCase
) : ViewModel() {
    private val _mostPopularVideoUiState: MutableStateFlow<MostPopularVideoUiState> = MutableStateFlow(MostPopularResultEmpty)

    private val _categoriesPopularVideoUiState: MutableStateFlow<CategoryPopularVideoUiState> = MutableStateFlow(CategoryPopularResultEmpty)

    val mostPopularVideoUiState: StateFlow<MostPopularVideoUiState> get() = _mostPopularVideoUiState.asStateFlow()
    val categoriesPopularVideoUiState: StateFlow<CategoryPopularVideoUiState> get() = _categoriesPopularVideoUiState.asStateFlow()

    fun getMostPopularVideo(
        chart: String,
    ) = viewModelScope.launch {
        videoUseCase.getMostPopularVideo(chart).onSuccess { videoEntitiy ->
            val mostPopularItems = creatMostPopularVideoListItems(videoEntitiy)
            _mostPopularVideoUiState.update {
                if (mostPopularItems.isEmpty()) {
                    MostPopularResultEmpty
                } else {
                    MostPopularVideoAddList(mostPopularItems)
                }
            }
        }.onFailure { throwable ->
            _mostPopularVideoUiState.update {
                when (throwable) {
                    is QuotaExceededException -> MostPopularQuotaExceeded
                    is TimeoutException -> MostPopularTimeout
                    is NetworkException -> MostPopularNetwork
                    else -> MostPopularUnknown
                }
            }

        }

    }

    fun getCategoriesPopularVideo(
        chart: String,
        videoCategoryId: String
    ) = viewModelScope.launch {
        videoUseCase.getCategoryPopularVideo(chart, videoCategoryId).onSuccess { videoEntitiy ->
            val categoryPopularItems = creatCategoryPopularItems(videoEntitiy)
            _categoriesPopularVideoUiState.update {
                if (categoryPopularItems.isEmpty()) {
                    CategoryPopularResultEmpty
                } else {
                    CategoryPopularAddList(categoryPopularItems)
                }
            }
        }.onFailure { throwable ->
            _categoriesPopularVideoUiState.update {
                when (throwable) {
                    is QuotaExceededException -> CategoryPopularQuotaExceeded
                    is TimeoutException -> CategoryPopularTimeout
                    is NetworkException -> CategoryPopularNetwork
                    else -> CategoryPopularUnknown
                }
            }

        }
    }


    private fun creatMostPopularVideoListItems(entity: VideoEntity): List<HomeItem.MostPopularItem> {
        return entity.items.map {
            val snippet = it.snippet
            HomeItem.MostPopularItem(
                snippet.thumbnails.high.url,
                snippet.title,
                snippet.description,
                snippet.channelTitle
            )
        }
    }

    private fun creatCategoryPopularItems(entity: VideoEntity): List<HomeItem.CategoryPopularItem> {
        return entity.items.map {
            val snippet = it.snippet
            HomeItem.CategoryPopularItem(
                snippet.thumbnails.high.url,
                snippet.title,
                snippet.description,
                snippet.channelTitle
            )
        }
    }
}








