package kr.camp.youtube.extension

import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.addOnScrolled(scrolledScope: (RecyclerView, Int, Int) -> Unit) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            scrolledScope(recyclerView, dx, dy)
        }
    })
}