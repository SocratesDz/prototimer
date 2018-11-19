package com.socratesdiaz.prototimer.data.models.jira

import com.squareup.moshi.Json

data class EditMetaBean(

    @Json(name = "fields")
    val fields: String? = null
)