package com.socratesdiaz.prototimer.data.source.remote.jira

import com.socratesdiaz.prototimer.data.models.jira.SearchResultsBean
import com.socratesdiaz.prototimer.data.models.jira.request.JQLRequest
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface JiraApiService {
    @POST("search")
    fun search(@Body searchRequest: JQLRequest): Single<SearchResultsBean>
}