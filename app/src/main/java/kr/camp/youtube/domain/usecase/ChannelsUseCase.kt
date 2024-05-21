package kr.camp.youtube.domain.usecase

import kr.camp.youtube.data.model.ChannelsResponce.ChannelsEntity
import kr.camp.youtube.domain.mapper.toEntity
import kr.camp.youtube.domain.repository.ChannelsRepository

class ChannelsUseCase (
    private val channelsRepository: ChannelsRepository
) {
    suspend operator fun invoke(id: String): Result<ChannelsEntity> {
        return runCatching {
            channelsRepository.getChannels(id).toEntity()
        }
    }
}
