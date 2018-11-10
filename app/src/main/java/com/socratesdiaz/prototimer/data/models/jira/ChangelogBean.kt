package com.socratesdiaz.prototimer.data.models.jira

import com.squareup.moshi.Json

data class ChangelogBean(

    @Json(name = "total")
    val total: Int? = null,

    @Json(name = "maxResults")
    val maxResults: Int? = null,

    @Json(name = "histories")
    val histories: List<ChangeHistoryBean?>? = null,

    @Json(name = "startAt")
    val startAt: Int? = null
)