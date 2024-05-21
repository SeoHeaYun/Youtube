package kr.camp.youtube

import kotlinx.coroutines.runBlocking
import kr.camp.youtube.data.repository.SearchRepositoryImpl
import kr.camp.youtube.data.repository.VideoRepositoryImpl
import kr.camp.youtube.network.YoutubeRetrofitClient
import org.junit.Test

class RetrofitTest {

    @Test
    fun retrofit_test() = runBlocking {
        val searchRepository = SearchRepositoryImpl(YoutubeRetrofitClient.searchDataSource)
        searchRepository.getSearch("농구").items.forEach {
            println(it)
        }
    }

    @Test
    fun retrofit_test2() = runBlocking {
        val videoRepository = VideoRepositoryImpl(YoutubeRetrofitClient.videoDataSource)
        videoRepository.getMostPopularVideo("mostPopular").items.forEach{
            println(it)
        }
    }
}