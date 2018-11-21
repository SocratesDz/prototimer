package com.socratesdiaz.prototimer.feature.search.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.socratesdiaz.prototimer.feature.search.usecase.SearchUseCase
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class SearchViewModelFactory(private val searchUseCase: SearchUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            return SearchViewModel(searchUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class.")
    }
}