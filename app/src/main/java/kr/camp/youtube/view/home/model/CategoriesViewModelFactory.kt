package kr.camp.youtube.view.home.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import kr.camp.youtube.data.repository.CategoriesRepositoryImpl
import kr.camp.youtube.domain.usecase.CategoriesUseCase
import kr.camp.youtube.network.YoutubeRetrofitClient

class CategoriesViewModelFactory: ViewModelProvider.Factory {
    private val categoriesUseCase by lazy {
        val categoriesDataSource = YoutubeRetrofitClient.videoCategoriesDataSource
        val categoriesRepository = CategoriesRepositoryImpl(categoriesDataSource)
        CategoriesUseCase(categoriesRepository)
    }

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return VideoViewModel(categoriesUseCase) as T
    }

}