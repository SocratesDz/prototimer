package com.socratesdiaz.prototimer.feature.search.usecase

import com.socratesdiaz.prototimer.data.models.jira.SearchResultsBean
import com.socratesdiaz.prototimer.data.models.jira.request.JQLRequest
import com.socratesdiaz.prototimer.data.source.remote.jira.JiraApiService
import io.reactivex.Single

class SearchUseCaseImpl(val api: JiraApiService): SearchUseCase {
    override fun searchTask(term: String): Single<SearchResultsBean> {
        return api.search(JQLRequest(jql = "summary ~ $term"))
    }
}