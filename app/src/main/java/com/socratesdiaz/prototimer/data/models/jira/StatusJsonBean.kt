package com.socratesdiaz.prototimer.data.models.jira

import com.squareup.moshi.Json

data class StatusJsonBean(

	@Json(name="name")
	val name: String? = null,

	@Json(name="self")
	val self: String? = null,

	@Json(name="description")
	val description: String? = null,

	@Json(name="iconUrl")
	val iconUrl: String? = null,

	@Json(name="id")
	val id: String? = null,

	@Json(name="statusCategory")
	val statusCategory: StatusCategoryJsonBean? = null
)