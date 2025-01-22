// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package algoliasearch.client

import algoliasearch.api.AnalyticsClient
import algoliasearch.config.*
import algoliasearch.{EchoInterceptor, assertError}
import algoliasearch.analytics.*
import algoliasearch.exception.*
import org.json4s.*
import org.json4s.native.JsonParser.*
import org.json4s.native.Serialization
import org.json4s.native.Serialization.write
import org.scalatest.funsuite.AnyFunSuite

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor}

class AnalyticsTest extends AnyFunSuite {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: Formats = org.json4s.DefaultFormats

  def testClient(
      appId: String = "appId",
      apiKey: String = "apiKey",
      region: String = null
  ): (AnalyticsClient, EchoInterceptor) = {
    val echo = EchoInterceptor()
    (
      AnalyticsClient(
        appId = appId,
        apiKey = apiKey,
        region = Option(region),
        clientOptions = ClientOptions
          .builder()
          .withRequesterConfig(requester => requester.withInterceptor(echo))
          .build()
      ),
      echo
    )
  }

  test("calls api with correct user agent") {
    val (client, echo) = testClient()

    Await.ready(
      client.customPost[JObject](
        path = "1/test"
      ),
      Duration.Inf
    )
    val regexp =
      """^Algolia for Scala \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Analytics (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$""".r
    val header = echo.lastResponse.get.headers("user-agent")
    assert(header.matches(regexp.regex), s"Expected $header to match the following regex: ${regexp.regex}")
  }

  test("the user agent contains the latest version") {
    val (client, echo) = testClient()

    Await.ready(
      client.customPost[JObject](
        path = "1/test"
      ),
      Duration.Inf
    )
    val regexp = """^Algolia for Scala \(2.13.0\).*""".r
    val header = echo.lastResponse.get.headers("user-agent")
    assert(header.matches(regexp.regex), s"Expected $header to match the following regex: ${regexp.regex}")
  }

  test("fallbacks to the alias when region is not given") {

    val (client, echo) = testClient(appId = "my-app-id", apiKey = "my-api-key")

    Await.ready(
      client.getAverageClickPosition(
        index = "my-index"
      ),
      Duration.Inf
    )
    assert(echo.lastResponse.get.host == "analytics.algolia.com")
  }

  test("uses the correct region") {

    val (client, echo) = testClient(appId = "my-app-id", apiKey = "my-api-key", region = "de")

    Await.ready(
      client.customPost[JObject](
        path = "test"
      ),
      Duration.Inf
    )
    assert(echo.lastResponse.get.host == "analytics.de.algolia.com")
  }

  test("throws when incorrect region is given") {

    assertError("`region` must be one of the following: de, us") {
      val (client, echo) = testClient(appId = "my-app-id", apiKey = "my-api-key", region = "not_a_region")
    }
  }

  test("getAverageClickPosition throws without index") {
    val (client, echo) = testClient()

    assertError("Parameter `index` is required when calling `getClickPositions`.") {
      Await.ready(
        client.getClickPositions(
          index = null
        ),
        Duration.Inf
      )
    }
  }

  test("switch API key") {

    val client = AnalyticsClient(
      appId = "test-app-id",
      apiKey = "test-api-key",
      region = Option("us"),
      clientOptions = ClientOptions
        .builder()
        .withHosts(
          List(
            Host(
              if (System.getenv("CI") == "true") "localhost" else "host.docker.internal",
              Set(CallType.Read, CallType.Write),
              "http",
              Option(6683)
            )
          )
        )
        .build()
    )

    {
      var res = Await.result(
        client.customGet[JObject](
          path = "check-api-key/1"
        ),
        Duration.Inf
      )
      assert(write(res) == "{\"headerAPIKeyValue\":\"test-api-key\"}")
    }

    {

      client.setClientApiKey(
        apiKey = "updated-api-key"
      )
    }

    {
      var res = Await.result(
        client.customGet[JObject](
          path = "check-api-key/2"
        ),
        Duration.Inf
      )
      assert(write(res) == "{\"headerAPIKeyValue\":\"updated-api-key\"}")
    }
  }
}
