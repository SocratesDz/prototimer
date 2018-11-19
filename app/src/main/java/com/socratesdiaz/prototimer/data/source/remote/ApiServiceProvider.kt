package com.socratesdiaz.prototimer.data.source.remote

import com.socratesdiaz.prototimer.data.source.remote.jira.JiraApiService

interface ApiServiceProvider {
    fun provideJiraApiService() : JiraApiService
}