package com.socratesdiaz.prototimer.data.models.jira

import com.squareup.moshi.Json

data class IssueBean(

	@Json(name="schema")
	val schema: String? = null,

	@Json(name="editmeta")
	val editmeta: EditMetaBean? = null,

	@Json(name="changelog")
	val changelog: ChangelogBean? = null,

	@Json(name="transitions")
	val transitions: List<TransitionBean?>? = null,

	@Json(name="renderedFields")
	val renderedFields: String? = null,

	@Json(name="expand")
	val expand: String? = null,

	@Json(name="names")
	val names: String? = null,

	@Json(name="operations")
	val operations: OpsbarBean? = null,

	@Json(name="versionedRepresentations")
	val versionedRepresentations: String? = null,

	@Json(name="editMeta")
	val editMeta: EditMetaBean? = null,

	@Json(name="self")
	val self: String? = null,

	@Json(name="id")
	val id: String? = null,

	@Json(name="fields")
	val fields: String? = null,

	@Json(name="key")
	val key: String? = null,

	@Json(name="properties")
	val properties: String? = null
)