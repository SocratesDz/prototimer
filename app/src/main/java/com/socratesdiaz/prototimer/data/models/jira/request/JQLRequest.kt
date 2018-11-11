package com.socratesdiaz.prototimer.data.models.jira.request

data class JQLRequest(
    var jql: String,
    var startAt: Int? = 0,
    var maxResults: Int? = 50,
    var fields: List<String>? = emptyList(),
    var validateQuery: String? = "strict",
    var expand: List<String>? = emptyList(),
    var properties: List<String>? = emptyList(),
    var fieldsByKeys: Boolean? = false
)