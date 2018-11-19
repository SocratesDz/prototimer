package com.socratesdiaz.prototimer.feature.search.usecase

import com.socratesdiaz.prototimer.data.models.jira.SearchResultsBean
import io.reactivex.Single

interface SearchUseCase {
    fun searchTask(term: String): Single<SearchResultsBean>
}