// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package algoliasearch.requests

import algoliasearch.EchoInterceptor
import algoliasearch.api.AbtestingClient
import algoliasearch.config.*
import algoliasearch.abtesting.*
import org.json4s.*
import org.json4s.native.JsonParser.*
import org.scalatest.funsuite.AnyFunSuite

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor}

class AbtestingTest extends AnyFunSuite {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: Formats = JsonSupport.format

  def testClient(): (AbtestingClient, EchoInterceptor) = {
    val echo = EchoInterceptor()
    (
      AbtestingClient(
        appId = "appId",
        apiKey = "apiKey",
        region = Some("us"),
        clientOptions = ClientOptions
          .builder()
          .withRequesterConfig(requester => requester.withInterceptor(echo))
          .build()
      ),
      echo
    )
  }

  test("addABTests with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.addABTests(
      addABTestsRequest = AddABTestsRequest(
        endAt = "2022-12-31T00:00:00.000Z",
        name = "myABTest",
        variants = Seq(
          AbTestsVariant(
            index = "AB_TEST_1",
            trafficPercentage = 30
          ),
          AbTestsVariant(
            index = "AB_TEST_2",
            trafficPercentage = 50
          )
        )
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/abtests")
    assert(res.method == "POST")
    val expectedBody = parse(
      """{"endAt":"2022-12-31T00:00:00.000Z","name":"myABTest","variants":[{"index":"AB_TEST_1","trafficPercentage":30},{"index":"AB_TEST_2","trafficPercentage":50}]}"""
    )
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
  }

  test("allow del method for a custom path with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.customDelete[JObject](
      path = "test/minimal"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/test/minimal")
    assert(res.method == "DELETE")
    assert(res.body.isEmpty)
  }

  test("allow del method for a custom path with all parameters1") {
    val (client, echo) = testClient()
    val future = client.customDelete[JObject](
      path = "test/all",
      parameters = Some(Map("query" -> "parameters"))
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/test/all")
    assert(res.method == "DELETE")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"query":"parameters"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("allow get method for a custom path with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.customGet[JObject](
      path = "test/minimal"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/test/minimal")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
  }

  test("allow get method for a custom path with all parameters1") {
    val (client, echo) = testClient()
    val future = client.customGet[JObject](
      path = "test/all",
      parameters = Some(Map("query" -> "parameters with space"))
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/test/all")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"query":"parameters%20with%20space"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("requestOptions should be escaped too2") {
    val (client, echo) = testClient()
    val future = client.customGet[JObject](
      path = "test/all",
      parameters = Some(Map("query" -> "to be overriden")),
      requestOptions = Some(
        RequestOptions
          .builder()
          .withQueryParameter("query", "parameters with space")
          .withQueryParameter("and an array", Seq("array", "with spaces"))
          .withHeader("x-header-1", "spaces are left alone")
          .build()
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/test/all")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"query":"parameters%20with%20space","and%20an%20array":"array%2Cwith%20spaces"}""")
      .asInstanceOf[JObject]
      .obj
      .toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
    val expectedHeaders = parse("""{"x-header-1":"spaces are left alone"}""").asInstanceOf[JObject].obj.toMap
    val actualHeaders = res.headers
    for ((k, v) <- expectedHeaders) {
      assert(actualHeaders.contains(k))
      assert(actualHeaders(k) == v.asInstanceOf[JString].s)
    }
  }

  test("allow post method for a custom path with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.customPost[JObject](
      path = "test/minimal"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/test/minimal")
    assert(res.method == "POST")
    val expectedBody = parse("""{}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
  }

  test("allow post method for a custom path with all parameters1") {
    val (client, echo) = testClient()
    val future = client.customPost[JObject](
      path = "test/all",
      parameters = Some(Map("query" -> "parameters")),
      body = Some(JObject(List(JField("body", JString("parameters")))))
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/test/all")
    assert(res.method == "POST")
    val expectedBody = parse("""{"body":"parameters"}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
    val expectedQuery = parse("""{"query":"parameters"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("requestOptions can override default query parameters2") {
    val (client, echo) = testClient()
    val future = client.customPost[JObject](
      path = "test/requestOptions",
      parameters = Some(Map("query" -> "parameters")),
      body = Some(JObject(List(JField("facet", JString("filters"))))),
      requestOptions = Some(
        RequestOptions
          .builder()
          .withQueryParameter("query", "myQueryParameter")
          .build()
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/test/requestOptions")
    assert(res.method == "POST")
    val expectedBody = parse("""{"facet":"filters"}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
    val expectedQuery = parse("""{"query":"myQueryParameter"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("requestOptions merges query parameters with default ones3") {
    val (client, echo) = testClient()
    val future = client.customPost[JObject](
      path = "test/requestOptions",
      parameters = Some(Map("query" -> "parameters")),
      body = Some(JObject(List(JField("facet", JString("filters"))))),
      requestOptions = Some(
        RequestOptions
          .builder()
          .withQueryParameter("query2", "myQueryParameter")
          .build()
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/test/requestOptions")
    assert(res.method == "POST")
    val expectedBody = parse("""{"facet":"filters"}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
    val expectedQuery = parse("""{"query":"parameters","query2":"myQueryParameter"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("requestOptions can override default headers4") {
    val (client, echo) = testClient()
    val future = client.customPost[JObject](
      path = "test/requestOptions",
      parameters = Some(Map("query" -> "parameters")),
      body = Some(JObject(List(JField("facet", JString("filters"))))),
      requestOptions = Some(
        RequestOptions
          .builder()
          .withHeader("x-algolia-api-key", "ALGOLIA_API_KEY")
          .build()
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/test/requestOptions")
    assert(res.method == "POST")
    val expectedBody = parse("""{"facet":"filters"}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
    val expectedQuery = parse("""{"query":"parameters"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
    val expectedHeaders = parse("""{"x-algolia-api-key":"ALGOLIA_API_KEY"}""").asInstanceOf[JObject].obj.toMap
    val actualHeaders = res.headers
    for ((k, v) <- expectedHeaders) {
      assert(actualHeaders.contains(k))
      assert(actualHeaders(k) == v.asInstanceOf[JString].s)
    }
  }

  test("requestOptions merges headers with default ones5") {
    val (client, echo) = testClient()
    val future = client.customPost[JObject](
      path = "test/requestOptions",
      parameters = Some(Map("query" -> "parameters")),
      body = Some(JObject(List(JField("facet", JString("filters"))))),
      requestOptions = Some(
        RequestOptions
          .builder()
          .withHeader("x-algolia-api-key", "ALGOLIA_API_KEY")
          .build()
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/test/requestOptions")
    assert(res.method == "POST")
    val expectedBody = parse("""{"facet":"filters"}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
    val expectedQuery = parse("""{"query":"parameters"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
    val expectedHeaders = parse("""{"x-algolia-api-key":"ALGOLIA_API_KEY"}""").asInstanceOf[JObject].obj.toMap
    val actualHeaders = res.headers
    for ((k, v) <- expectedHeaders) {
      assert(actualHeaders.contains(k))
      assert(actualHeaders(k) == v.asInstanceOf[JString].s)
    }
  }

  test("requestOptions queryParameters accepts booleans6") {
    val (client, echo) = testClient()
    val future = client.customPost[JObject](
      path = "test/requestOptions",
      parameters = Some(Map("query" -> "parameters")),
      body = Some(JObject(List(JField("facet", JString("filters"))))),
      requestOptions = Some(
        RequestOptions
          .builder()
          .withQueryParameter("isItWorking", true)
          .build()
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/test/requestOptions")
    assert(res.method == "POST")
    val expectedBody = parse("""{"facet":"filters"}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
    val expectedQuery = parse("""{"query":"parameters","isItWorking":"true"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("requestOptions queryParameters accepts integers7") {
    val (client, echo) = testClient()
    val future = client.customPost[JObject](
      path = "test/requestOptions",
      parameters = Some(Map("query" -> "parameters")),
      body = Some(JObject(List(JField("facet", JString("filters"))))),
      requestOptions = Some(
        RequestOptions
          .builder()
          .withQueryParameter("myParam", 2)
          .build()
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/test/requestOptions")
    assert(res.method == "POST")
    val expectedBody = parse("""{"facet":"filters"}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
    val expectedQuery = parse("""{"query":"parameters","myParam":"2"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("requestOptions queryParameters accepts list of string8") {
    val (client, echo) = testClient()
    val future = client.customPost[JObject](
      path = "test/requestOptions",
      parameters = Some(Map("query" -> "parameters")),
      body = Some(JObject(List(JField("facet", JString("filters"))))),
      requestOptions = Some(
        RequestOptions
          .builder()
          .withQueryParameter("myParam", Seq("b and c", "d"))
          .build()
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/test/requestOptions")
    assert(res.method == "POST")
    val expectedBody = parse("""{"facet":"filters"}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
    val expectedQuery = parse("""{"query":"parameters","myParam":"b%20and%20c%2Cd"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("requestOptions queryParameters accepts list of booleans9") {
    val (client, echo) = testClient()
    val future = client.customPost[JObject](
      path = "test/requestOptions",
      parameters = Some(Map("query" -> "parameters")),
      body = Some(JObject(List(JField("facet", JString("filters"))))),
      requestOptions = Some(
        RequestOptions
          .builder()
          .withQueryParameter("myParam", Seq(true, true, false))
          .build()
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/test/requestOptions")
    assert(res.method == "POST")
    val expectedBody = parse("""{"facet":"filters"}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
    val expectedQuery =
      parse("""{"query":"parameters","myParam":"true%2Ctrue%2Cfalse"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("requestOptions queryParameters accepts list of integers10") {
    val (client, echo) = testClient()
    val future = client.customPost[JObject](
      path = "test/requestOptions",
      parameters = Some(Map("query" -> "parameters")),
      body = Some(JObject(List(JField("facet", JString("filters"))))),
      requestOptions = Some(
        RequestOptions
          .builder()
          .withQueryParameter("myParam", Seq(1, 2))
          .build()
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/test/requestOptions")
    assert(res.method == "POST")
    val expectedBody = parse("""{"facet":"filters"}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
    val expectedQuery = parse("""{"query":"parameters","myParam":"1%2C2"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("allow put method for a custom path with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.customPut[JObject](
      path = "test/minimal"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/test/minimal")
    assert(res.method == "PUT")
    val expectedBody = parse("""{}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
  }

  test("allow put method for a custom path with all parameters1") {
    val (client, echo) = testClient()
    val future = client.customPut[JObject](
      path = "test/all",
      parameters = Some(Map("query" -> "parameters")),
      body = Some(JObject(List(JField("body", JString("parameters")))))
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/test/all")
    assert(res.method == "PUT")
    val expectedBody = parse("""{"body":"parameters"}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
    val expectedQuery = parse("""{"query":"parameters"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("deleteABTest") {
    val (client, echo) = testClient()
    val future = client.deleteABTest(
      id = 42
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/abtests/42")
    assert(res.method == "DELETE")
    assert(res.body.isEmpty)
  }

  test("estimate AB Test sample size") {
    val (client, echo) = testClient()
    val future = client.estimateABTest(
      estimateABTestRequest = EstimateABTestRequest(
        configuration = EstimateConfiguration(
          emptySearch = Some(
            EmptySearch(
              exclude = Some(true)
            )
          ),
          minimumDetectableEffect = MinimumDetectableEffect(
            size = 0.03,
            metric = EffectMetric.withName("conversionRate")
          )
        ),
        variants = Seq(
          AbTestsVariant(
            index = "AB_TEST_1",
            trafficPercentage = 50
          ),
          AbTestsVariant(
            index = "AB_TEST_2",
            trafficPercentage = 50
          )
        )
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/abtests/estimate")
    assert(res.method == "POST")
    val expectedBody = parse(
      """{"configuration":{"emptySearch":{"exclude":true},"minimumDetectableEffect":{"size":0.03,"metric":"conversionRate"}},"variants":[{"index":"AB_TEST_1","trafficPercentage":50},{"index":"AB_TEST_2","trafficPercentage":50}]}"""
    )
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
  }

  test("getABTest") {
    val (client, echo) = testClient()
    val future = client.getABTest(
      id = 42
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/abtests/42")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
  }

  test("listABTests with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.listABTests(
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/abtests")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
  }

  test("listABTests with parameters1") {
    val (client, echo) = testClient()
    val future = client.listABTests(
      offset = Some(0),
      limit = Some(21),
      indexPrefix = Some("cts_e2e ab"),
      indexSuffix = Some("t")
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/abtests")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"offset":"0","limit":"21","indexPrefix":"cts_e2e%20ab","indexSuffix":"t"}""")
      .asInstanceOf[JObject]
      .obj
      .toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("scheduleABTest with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.scheduleABTest(
      scheduleABTestsRequest = ScheduleABTestsRequest(
        endAt = "2022-12-31T00:00:00.000Z",
        scheduledAt = "2022-11-31T00:00:00.000Z",
        name = "myABTest",
        variants = Seq(
          AbTestsVariant(
            index = "AB_TEST_1",
            trafficPercentage = 30
          ),
          AbTestsVariant(
            index = "AB_TEST_2",
            trafficPercentage = 50
          )
        )
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/abtests/schedule")
    assert(res.method == "POST")
    val expectedBody = parse(
      """{"endAt":"2022-12-31T00:00:00.000Z","scheduledAt":"2022-11-31T00:00:00.000Z","name":"myABTest","variants":[{"index":"AB_TEST_1","trafficPercentage":30},{"index":"AB_TEST_2","trafficPercentage":50}]}"""
    )
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
  }

  test("stopABTest") {
    val (client, echo) = testClient()
    val future = client.stopABTest(
      id = 42
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/abtests/42/stop")
    assert(res.method == "POST")
    assert(res.body.contains("{}"))
  }

}
