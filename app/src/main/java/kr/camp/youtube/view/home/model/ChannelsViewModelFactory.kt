package kr.camp.youtube.view.home.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import kr.camp.youtube.data.repository.ChannelsRepositoryImpl
import kr.camp.youtube.domain.usecase.ChannelsUseCase
import kr.camp.youtube.network.YoutubeRetrofitClient

class ChannelsViewModelFactory: ViewModelProvider.Factory {

    private val channelsUseCase by lazy {
        val channelsDataSource = YoutubeRetrofitClient.ChannlesDataSource
        val channelsRepository = ChannelsRepositoryImpl(channelsDataSource)
        ChannelsUseCase(channelsRepository)
    }

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return VideoViewModel(channelsUseCase) as T
    }
}