package com.socratesdiaz.prototimer.data.models.jira

data class ChangeHistoryBean(
	val author: UserJsonBean? = null,
	val created: String? = null,
	val id: String? = null,
	val items: List<ChangeItemBean?>? = null
)
