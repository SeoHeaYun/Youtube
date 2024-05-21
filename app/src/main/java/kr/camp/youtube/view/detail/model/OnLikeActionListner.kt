package kr.camp.youtube.view.detail.model

interface OnLikeActionListner {
    fun onLike(item: LikeItemModel)
    fun onUnlike(item: LikeItemModel)
}