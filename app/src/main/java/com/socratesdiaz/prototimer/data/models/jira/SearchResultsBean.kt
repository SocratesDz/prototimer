package com.socratesdiaz.prototimer.data.models.jira

import com.squareup.moshi.Json

data class SearchResultsBean(

	@Json(name="schema")
	val schema: String? = null,

	@Json(name="warningMessages")
	val warningMessages: List<String?>? = null,

	@Json(name="expand")
	val expand: String? = null,

	@Json(name="total")
	val total: Int? = null,

	@Json(name="names")
	val names: String? = null,

	@Json(name="maxResults")
	val maxResults: Int? = null,

	@Json(name="issues")
	val issues: List<IssueBean?>? = null,

	@Json(name="startAt")
	val startAt: Int? = null
)