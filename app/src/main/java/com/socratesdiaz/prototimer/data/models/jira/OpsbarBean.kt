package com.socratesdiaz.prototimer.data.models.jira

import com.squareup.moshi.Json

data class OpsbarBean(

	@Json(name="linkGroups")
	val linkGroups: List<LinkGroupBean?>? = null
)