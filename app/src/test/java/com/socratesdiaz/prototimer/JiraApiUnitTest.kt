package com.socratesdiaz.prototimer

import com.socratesdiaz.prototimer.data.models.jira.request.JQLRequest
import com.socratesdiaz.prototimer.data.source.remote.ApiServiceProviderImpl
import com.socratesdiaz.prototimer.data.source.remote.jira.JiraApiService
import org.junit.Test

class JiraApiUnitTest {

    private fun createApi(): JiraApiService? = ApiServiceProviderImpl().provideJiraApiService()

    @Test
    fun `Search for an issue`() {
        val api = createApi()
        api?.search(JQLRequest(jql = "summary ~ \".*\" ORDER BY lastViewed DESC"))
            ?.test()
            ?.assertComplete()
    }
}