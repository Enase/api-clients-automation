// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package com.algolia.client

import com.algolia.client.api.PersonalizationClient
import com.algolia.client.configuration.*
import com.algolia.client.extensions.*
import com.algolia.client.model.personalization.*
import com.algolia.client.transport.*
import com.algolia.utils.*
import io.ktor.http.*
import kotlinx.coroutines.test.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.*
import kotlin.test.*

class PersonalizationTest {

  @Test
  fun `calls api with correct user agent`() = runTest {
    val client = PersonalizationClient(appId = "appId", apiKey = "apiKey", region = "us")
    client.runTest(
      call = {
        customPost(
          path = "1/test",
        )
      },
      intercept = {
        val regexp = "^Algolia for Kotlin \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Personalization (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$".toRegex()
        val header = it.headers["User-Agent"].orEmpty()
        assertTrue(actual = header.matches(regexp), message = "Expected $header to match the following regex: $regexp")
      },
    )
  }

  @Test
  fun `the user agent contains the latest version`() = runTest {
    val client = PersonalizationClient(appId = "appId", apiKey = "apiKey", region = "us")
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
  fun `throws when region is not given`() = runTest {
    assertFails {
      val client = PersonalizationClient(appId = "my-app-id", apiKey = "my-api-key", "")
    }.let { error -> assertError(error, "`region` is required and must be one of the following: eu, us".replace("%localhost%", if (System.getenv("CI") == "true") "localhost" else "host.docker.internal")) }
  }

  @Test
  fun `throws when incorrect region is given`() = runTest {
    assertFails {
      val client = PersonalizationClient(appId = "my-app-id", apiKey = "my-api-key", "not_a_region")
    }.let { error -> assertError(error, "`region` is required and must be one of the following: eu, us".replace("%localhost%", if (System.getenv("CI") == "true") "localhost" else "host.docker.internal")) }
  }

  @Test
  fun `does not throw when region is given`() = runTest {
    val client = PersonalizationClient(appId = "my-app-id", apiKey = "my-api-key", "us")
  }

  @Test
  fun `switch API key`() = runTest {
    val client = PersonalizationClient(appId = "test-app-id", apiKey = "test-api-key", "us", options = ClientOptions(hosts = listOf(Host(url = if (System.getenv("CI") == "true") "localhost" else "host.docker.internal", protocol = "http", port = 6683))))
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
