package kr.camp.youtube.view.search.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import kr.camp.youtube.domain.repository.SearchRepositoryImpl
import kr.camp.youtube.domain.usecase.SearchUseCase
import kr.camp.youtube.network.YoutubeRetrofitClient

class SearchViewModelFactory : ViewModelProvider.Factory {

    private val searchUseCase by lazy {
        val searchDataSource = YoutubeRetrofitClient.searchDataSource
        val searchRepository = SearchRepositoryImpl(searchDataSource)
        SearchUseCase(searchRepository)
    }

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return SearchViewModel(searchUseCase) as T
    }
}