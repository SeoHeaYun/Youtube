package kr.camp.youtube.view.detail.model

import java.io.Serializable

/**
 * 검색 결과로 반환되는 각 이미지 아이템에 대한 모델 클래스입니다.
 *
 * @property title 이미지의 제목입니다.
 * @property dateTime 이미지가 생성 또는 업로드된 날짜와 시간입니다.
 * @property url 이미지의 URL 주소입니다.
 * @property isLike 사용자가 해당 이미지를 "좋아요" 했는지의 여부를 나타냅니다.
 */


data class LikeItemModel (
    var title: String?,
    var channelTitle: String?,
    var url: String?,
    var desc: String?,
    var isLike: Boolean = false
): Serializable {
    fun changeLike() {
        isLike = !isLike
    }
}

object DummyDataManager {

    private val dummyData: MutableList<LikeItemModel> = mutableListOf(
        LikeItemModel(
            "고양이가 나오는 영상",
            "고양이채널",
            "https://i.ytimg.com/vi/aip80BfeuDg/hqdefault.jpg",
            "고양이가 나오는 영상입니당",
            true
        ),
        LikeItemModel(
            "강아지가 나오는 영상",
            "강아지채널",
            "https://i.ytimg.com/vi/BR7OFcEFRDw/hqdefault.jpg",
            "강아지가 나오는 영상입니당",
            true
        ),
        LikeItemModel(
            "조랑말이 나오는 동영상",
            "조랑말",
            "https://i.ytimg.com/vi/FRqjPXL5i0M/hqdefault.jpg",
            "조랑말이 나오는 영상입니당",
            true
        )
    )

    fun getDummyData(): List<LikeItemModel> {
        return dummyData
    }

    fun updateDummyData(updatedData: List<LikeItemModel>) {
        dummyData.clear()
        dummyData.addAll(updatedData)
    }
}

