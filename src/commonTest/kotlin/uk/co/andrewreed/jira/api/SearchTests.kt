package uk.co.andrewreed.jira.api

import uk.co.andrewreed.jira.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class SearchTests: ClientTest() {

    @Test
    fun searchUsingJql() = runTest {

        val issues = client.search.searchUsingJql("project=foo")
        println(issues)
        assertEquals(0, issues.size)
    }

    @Test
    fun searchUsingJqlWithQueryOptions() = runTest {

        val issues = client.search.searchUsingJql("project=foo", "&fields=issues.key")
        println(issues)
        assertEquals(0, issues.size)
    }
}