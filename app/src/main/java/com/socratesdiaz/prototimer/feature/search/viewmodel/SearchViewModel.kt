package com.socratesdiaz.prototimer.feature.search.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.socratesdiaz.prototimer.feature.search.usecase.SearchUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SearchViewModel(private val searchUseCase: SearchUseCase) : ViewModel() {

    private val searchResults = MutableLiveData<SearchViewState>()
    private val compositeDisposable = CompositeDisposable()

    fun searchTask(term: String) {
        performSearchTask(term)
    }

    fun searchResults(): LiveData<SearchViewState> = searchResults

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    private fun performSearchTask(term: String) {
        compositeDisposable.add(searchUseCase.searchTask(term)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { searchResults.value = SearchViewState.Loading }
            .subscribe(
                { searchResults.value =
                        if(it?.issues?.isEmpty() == true) SearchViewState.NoResults
                        else SearchViewState.Results(it?.issues)
                },
                { searchResults.value = SearchViewState.Error(it.localizedMessage) }))
    }
}
