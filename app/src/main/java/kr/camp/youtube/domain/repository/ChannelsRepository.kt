package kr.camp.youtube.domain.repository

import kr.camp.youtube.data.model.ChannelsResponse.ChannelsResponse

interface ChannelsRepository {
        suspend fun getChannels(id: String): ChannelsResponse

}