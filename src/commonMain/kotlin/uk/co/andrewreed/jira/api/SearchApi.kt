package uk.co.andrewreed.jira.api

import io.ktor.http.*
import uk.co.andrewreed.jira.api.models.Issue
import uk.co.andrewreed.jira.api.models.ResponseIssues

class SearchApi(config: JiraConfig) : Client(config) {

    ///rest/api/latest/search?jql={searchTerm}${querOptions}
    suspend fun searchUsingJql(searchTerm: String, queryOptions: String = ""): List<Issue> =
        "$searchTerm&maxResults=200&fields*all,comment$queryOptions".encodeURLQueryComponent()
            .let { encodedSearchTerm ->
                createAuthenticatedRequest(
                    ResponseIssues.serializer(),
                    "/rest/api/latest/search?jql=$encodedSearchTerm"
                ).issues
            }
}