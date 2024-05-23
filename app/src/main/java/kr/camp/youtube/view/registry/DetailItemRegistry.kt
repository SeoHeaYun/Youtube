package kr.camp.youtube.view.registry

import kr.camp.youtube.view.key.item.DetailItem

object DetailItemRegistry {

    private var _likes = mutableSetOf<DetailItem>()
    val likes: Set<DetailItem> get() = _likes

    fun isLike(detailItem: DetailItem): Boolean = _likes.contains(detailItem)

    fun setLikes(detailItems: MutableSet<DetailItem>) {
        this._likes = detailItems
    }

    fun addLike(detailItem: DetailItem) {
        _likes.add(detailItem)
    }

    fun removeLike(detailItem: DetailItem) {
        _likes.remove(detailItem)
    }

    fun switchLike(detailItem: DetailItem): Boolean {
        return if (isLike(detailItem)) {
            removeLike(detailItem)
            false
        } else {
            addLike(detailItem)
            true
        }
    }
}