package com.socratesdiaz.prototimer.data.models.jira.request

data class JQLRequest(
    var jql: String,
    var startAt: Int? = null,
    var maxResults: Int? = null,
    var fields: List<String>? = null,
    var validateQuery: String? = null,
    var expand: List<String>? = null,
    var properties: List<String>? = null,
    var fieldsByKeys: Boolean? = null
)