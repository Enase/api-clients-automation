// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package com.algolia.client

import com.algolia.client.api.MonitoringClient
import com.algolia.client.configuration.*
import com.algolia.client.extensions.*
import com.algolia.client.model.monitoring.*
import com.algolia.client.transport.*
import com.algolia.utils.*
import io.ktor.http.*
import kotlinx.coroutines.test.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.*
import kotlin.test.*

class MonitoringTest {

  @Test
  fun `calls api with correct user agent`() = runTest {
    val client = MonitoringClient(appId = "appId", apiKey = "apiKey")
    client.runTest(
      call = {
        customPost(
          path = "1/test",
        )
      },
      intercept = {
        val regexp = "^Algolia for Kotlin \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Monitoring (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$".toRegex()
        val header = it.headers["User-Agent"].orEmpty()
        assertTrue(actual = header.matches(regexp), message = "Expected $header to match the following regex: $regexp")
      },
    )
  }

  @Test
  fun `the user agent contains the latest version`() = runTest {
    val client = MonitoringClient(appId = "appId", apiKey = "apiKey")
    client.runTest(
      call = {
        customPost(
          path = "1/test",
        )
      },
      intercept = {
        val regexp = "^Algolia for Kotlin \\(3.10.1\\).*".toRegex()
        val header = it.headers["User-Agent"].orEmpty()
        assertTrue(actual = header.matches(regexp), message = "Expected $header to match the following regex: $regexp")
      },
    )
  }

  @Test
  fun `use the correct host`() = runTest {
    val client = MonitoringClient(appId = "my-app-id", apiKey = "my-api-key")
    client.runTest(
      call = {
        customDelete(
          path = "test",
        )
      },
      intercept = {
        assertEquals("status.algolia.com", it.url.host)
      },
    )
  }

  @Test
  fun `switch API key`() = runTest {
    val client = MonitoringClient(appId = "test-app-id", apiKey = "test-api-key", options = ClientOptions(hosts = listOf(Host(url = if (System.getenv("CI") == "true") "localhost" else "host.docker.internal", protocol = "http", port = 6683))))
    client.runTest(
      call = {
        customGet(
          path = "check-api-key/1",
        )
      },

      response = {
        val response = Json.encodeToString(it)
        assertEquals("{\"headerAPIKeyValue\":\"test-api-key\"}", response)
      },
    )
    client.runTest(
      call = {
        setClientApiKey(
          apiKey = "updated-api-key",
        )
      },
      intercept = {
      },
    )
    client.runTest(
      call = {
        customGet(
          path = "check-api-key/2",
        )
      },

      response = {
        val response = Json.encodeToString(it)
        assertEquals("{\"headerAPIKeyValue\":\"updated-api-key\"}", response)
      },
    )
  }
}
