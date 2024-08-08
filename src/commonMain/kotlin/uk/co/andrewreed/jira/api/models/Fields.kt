package uk.co.andrewreed.jira.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Fields(
    val flagged: Boolean = false,
    val sprint: Sprint? = null,
    val closedSprints: List<ClosedSprint> = emptyList(),
    val description: String?,
    val project: Project,
    val comment: Comments = Comments(emptyList()),
    val epic: Epic? = null,
    val worklog: Logs? = null,
    val updated: String,
    val timetracking: TimeTracking? = null
)