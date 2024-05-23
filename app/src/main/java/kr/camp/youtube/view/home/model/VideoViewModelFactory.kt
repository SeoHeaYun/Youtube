package kr.camp.youtube.view.home.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import kr.camp.youtube.data.repository.SearchRepositoryImpl
import kr.camp.youtube.data.repository.VideoRepositoryImpl
import kr.camp.youtube.domain.usecase.SearchUseCase
import kr.camp.youtube.domain.usecase.VideoUseCase
import kr.camp.youtube.network.YoutubeRetrofitClient
import kr.camp.youtube.view.search.model.SearchViewModel

class VideoViewModelFactory: ViewModelProvider.Factory {

    private val videoUseCase by lazy {
        val videoDataSource = YoutubeRetrofitClient.videoDataSource
        val videoRepository = VideoRepositoryImpl(videoDataSource)
        VideoUseCase(videoRepository)
    }



    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return VideoViewModel(videoUseCase) as T
    }
}


