package com.socratesdiaz.prototimer.feature.search.viewmodel

import com.socratesdiaz.prototimer.data.models.jira.IssueBean

sealed class SearchViewState {
    object Loading: SearchViewState()
    object NoResults: SearchViewState()
    class Results(val results: List<IssueBean?>?): SearchViewState()
    class Error(val errorMessage: String): SearchViewState()
}