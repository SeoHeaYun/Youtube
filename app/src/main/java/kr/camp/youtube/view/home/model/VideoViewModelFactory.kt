package kr.camp.youtube.view.home.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import kr.camp.youtube.data.repository.CategoriesRepositoryImpl
import kr.camp.youtube.data.repository.ChannelsRepositoryImpl
import kr.camp.youtube.data.repository.VideoRepositoryImpl
import kr.camp.youtube.domain.usecase.CategoriesUseCase
import kr.camp.youtube.domain.usecase.ChannelsUseCase
import kr.camp.youtube.domain.usecase.VideoUseCase
import kr.camp.youtube.network.YoutubeRetrofitClient

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


