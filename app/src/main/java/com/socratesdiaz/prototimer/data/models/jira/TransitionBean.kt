package com.socratesdiaz.prototimer.data.models.jira

import com.squareup.moshi.Json

data class TransitionBean(

	@Json(name="hasScreen")
	val hasScreen: Boolean? = null,

	@Json(name="expand")
	val expand: String? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="isGlobal")
	val isGlobal: Boolean? = null,

	@Json(name="isInitial")
	val isInitial: Boolean? = null,

	@Json(name="id")
	val id: String? = null,

	@Json(name="to")
	val to: StatusJsonBean? = null,

	@Json(name="isConditional")
	val isConditional: Boolean? = null,

	@Json(name="fields")
	val fields: String? = null
)