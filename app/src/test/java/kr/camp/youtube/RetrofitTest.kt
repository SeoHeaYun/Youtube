package kr.camp.youtube

import kotlinx.coroutines.runBlocking
import kr.camp.youtube.data.repository.SearchRepositoryImpl
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
}