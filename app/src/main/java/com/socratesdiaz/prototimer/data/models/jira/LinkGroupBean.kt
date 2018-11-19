package com.socratesdiaz.prototimer.data.models.jira

data class LinkGroupBean(
	val header: SimpleLinkBean? = null,
	val weight: Int? = null,
	val groups: List<LinkGroupBean?>? = null,
	val links: List<SimpleLinkBean?>? = null,
	val id: String? = null,
	val styleClass: String? = null
)
