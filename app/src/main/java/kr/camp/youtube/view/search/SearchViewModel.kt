package kr.camp.youtube.view.search

import androidx.lifecycle.ViewModel
import kr.camp.youtube.domain.usecase.SearchUseCase

class SearchViewModel(
    private val searchUseCase: SearchUseCase
) : ViewModel() {
}