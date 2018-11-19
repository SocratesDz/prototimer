package com.socratesdiaz.prototimer.data.models.jira

import com.squareup.moshi.Json

data class StatusCategoryJsonBean(

	@Json(name="colorName")
	val colorName: String? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="self")
	val self: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="key")
	val key: String? = null
)