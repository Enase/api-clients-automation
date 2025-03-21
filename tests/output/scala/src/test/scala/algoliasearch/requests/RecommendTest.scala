// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package algoliasearch.requests

import algoliasearch.EchoInterceptor
import algoliasearch.api.RecommendClient
import algoliasearch.config.*
import algoliasearch.recommend.*
import org.json4s.*
import org.json4s.native.JsonParser.*
import org.scalatest.funsuite.AnyFunSuite

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor}

class RecommendTest extends AnyFunSuite {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: Formats = JsonSupport.format

  def testClient(): (RecommendClient, EchoInterceptor) = {
    val echo = EchoInterceptor()
    (
      RecommendClient(
        appId = "appId",
        apiKey = "apiKey",
        clientOptions = ClientOptions
          .builder()
          .withRequesterConfig(requester => requester.withInterceptor(echo))
          .build()
      ),
      echo
    )
  }

  test("batch recommend rules") {
    val (client, echo) = testClient()
    val future = client.batchRecommendRules(
      indexName = "indexName",
      model = RecommendModels.withName("related-products")
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/indexes/indexName/related-products/recommend/rules/batch")
    assert(res.method == "POST")
    val expectedBody = parse("""{}""")
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

  test("deleteRecommendRule") {
    val (client, echo) = testClient()
    val future = client.deleteRecommendRule(
      indexName = "indexName",
      model = RecommendModels.withName("related-products"),
      objectID = "objectID"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/indexes/indexName/related-products/recommend/rules/objectID")
    assert(res.method == "DELETE")
    assert(res.body.isEmpty)
  }

  test("getRecommendRule") {
    val (client, echo) = testClient()
    val future = client.getRecommendRule(
      indexName = "indexName",
      model = RecommendModels.withName("related-products"),
      objectID = "objectID"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/indexes/indexName/related-products/recommend/rules/objectID")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
  }

  test("getRecommendStatus") {
    val (client, echo) = testClient()
    val future = client.getRecommendStatus(
      indexName = "indexName",
      model = RecommendModels.withName("related-products"),
      taskID = 12345L
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/indexes/indexName/related-products/task/12345")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
  }

  test("get recommendations for recommend model with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.getRecommendations(
      getRecommendationsParams = GetRecommendationsParams(
        requests = Seq(
          RelatedQuery(
            indexName = "indexName",
            objectID = "objectID",
            model = RelatedModel.withName("related-products"),
            threshold = 42.1
          )
        )
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/indexes/*/recommendations")
    assert(res.method == "POST")
    val expectedBody = parse(
      """{"requests":[{"indexName":"indexName","objectID":"objectID","model":"related-products","threshold":42.1}]}"""
    )
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
  }

  test("get recommendations with e2e to check oneOf model1") {
    val (client, echo) = testClient()
    val future = client.getRecommendations(
      getRecommendationsParams = GetRecommendationsParams(
        requests = Seq(
          RelatedQuery(
            indexName = "cts_e2e_browse",
            objectID = "Æon Flux",
            model = RelatedModel.withName("related-products"),
            threshold = 20.0,
            maxRecommendations = Some(2)
          )
        )
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/indexes/*/recommendations")
    assert(res.method == "POST")
    val expectedBody = parse(
      """{"requests":[{"indexName":"cts_e2e_browse","objectID":"Æon Flux","model":"related-products","threshold":20.0,"maxRecommendations":2}]}"""
    )
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
  }

  test("get recommendations for recommend model with all parameters2") {
    val (client, echo) = testClient()
    val future = client.getRecommendations(
      getRecommendationsParams = GetRecommendationsParams(
        requests = Seq(
          RelatedQuery(
            indexName = "indexName",
            objectID = "objectID",
            model = RelatedModel.withName("related-products"),
            threshold = 42.1,
            maxRecommendations = Some(10),
            queryParameters = Some(
              RecommendSearchParams(
                query = Some("myQuery"),
                facetFilters = Some(FacetFilters(Seq(FacetFilters("query"))))
              )
            ),
            fallbackParameters = Some(
              FallbackParams(
                query = Some("myQuery"),
                facetFilters = Some(FacetFilters(Seq(FacetFilters("fallback"))))
              )
            )
          )
        )
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/indexes/*/recommendations")
    assert(res.method == "POST")
    val expectedBody = parse(
      """{"requests":[{"indexName":"indexName","objectID":"objectID","model":"related-products","threshold":42.1,"maxRecommendations":10,"queryParameters":{"query":"myQuery","facetFilters":["query"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback"]}}]}"""
    )
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
  }

  test("get recommendations for trending model with minimal parameters3") {
    val (client, echo) = testClient()
    val future = client.getRecommendations(
      getRecommendationsParams = GetRecommendationsParams(
        requests = Seq(
          TrendingItemsQuery(
            indexName = "indexName",
            model = TrendingItemsModel.withName("trending-items"),
            threshold = 42.1,
            facetName = Some("facet"),
            facetValue = Some("value")
          )
        )
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/indexes/*/recommendations")
    assert(res.method == "POST")
    val expectedBody = parse(
      """{"requests":[{"indexName":"indexName","model":"trending-items","threshold":42.1,"facetName":"facet","facetValue":"value"}]}"""
    )
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
  }

  test("get recommendations for trending model with all parameters4") {
    val (client, echo) = testClient()
    val future = client.getRecommendations(
      getRecommendationsParams = GetRecommendationsParams(
        requests = Seq(
          TrendingItemsQuery(
            indexName = "indexName",
            model = TrendingItemsModel.withName("trending-items"),
            threshold = 42.1,
            maxRecommendations = Some(10),
            facetName = Some("myFacetName"),
            facetValue = Some("myFacetValue"),
            queryParameters = Some(
              RecommendSearchParams(
                query = Some("myQuery"),
                facetFilters = Some(FacetFilters(Seq(FacetFilters("query"))))
              )
            ),
            fallbackParameters = Some(
              FallbackParams(
                query = Some("myQuery"),
                facetFilters = Some(FacetFilters(Seq(FacetFilters("fallback"))))
              )
            )
          )
        )
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/indexes/*/recommendations")
    assert(res.method == "POST")
    val expectedBody = parse(
      """{"requests":[{"indexName":"indexName","model":"trending-items","threshold":42.1,"maxRecommendations":10,"facetName":"myFacetName","facetValue":"myFacetValue","queryParameters":{"query":"myQuery","facetFilters":["query"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback"]}}]}"""
    )
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
  }

  test("get multiple recommendations with minimal parameters5") {
    val (client, echo) = testClient()
    val future = client.getRecommendations(
      getRecommendationsParams = GetRecommendationsParams(
        requests = Seq(
          RelatedQuery(
            indexName = "indexName1",
            objectID = "objectID1",
            model = RelatedModel.withName("related-products"),
            threshold = 21.7
          ),
          RelatedQuery(
            indexName = "indexName2",
            objectID = "objectID2",
            model = RelatedModel.withName("related-products"),
            threshold = 21.7
          )
        )
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/indexes/*/recommendations")
    assert(res.method == "POST")
    val expectedBody = parse(
      """{"requests":[{"indexName":"indexName1","objectID":"objectID1","model":"related-products","threshold":21.7},{"indexName":"indexName2","objectID":"objectID2","model":"related-products","threshold":21.7}]}"""
    )
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
  }

  test("get multiple recommendations with all parameters6") {
    val (client, echo) = testClient()
    val future = client.getRecommendations(
      getRecommendationsParams = GetRecommendationsParams(
        requests = Seq(
          RelatedQuery(
            indexName = "indexName1",
            objectID = "objectID1",
            model = RelatedModel.withName("related-products"),
            threshold = 21.7,
            maxRecommendations = Some(10),
            queryParameters = Some(
              RecommendSearchParams(
                query = Some("myQuery"),
                facetFilters = Some(FacetFilters(Seq(FacetFilters("query1"))))
              )
            ),
            fallbackParameters = Some(
              FallbackParams(
                query = Some("myQuery"),
                facetFilters = Some(FacetFilters(Seq(FacetFilters("fallback1"))))
              )
            )
          ),
          RelatedQuery(
            indexName = "indexName2",
            objectID = "objectID2",
            model = RelatedModel.withName("related-products"),
            threshold = 21.7,
            maxRecommendations = Some(10),
            queryParameters = Some(
              RecommendSearchParams(
                query = Some("myQuery"),
                facetFilters = Some(FacetFilters(Seq(FacetFilters("query2"))))
              )
            ),
            fallbackParameters = Some(
              FallbackParams(
                query = Some("myQuery"),
                facetFilters = Some(FacetFilters(Seq(FacetFilters("fallback2"))))
              )
            )
          )
        )
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/indexes/*/recommendations")
    assert(res.method == "POST")
    val expectedBody = parse(
      """{"requests":[{"indexName":"indexName1","objectID":"objectID1","model":"related-products","threshold":21.7,"maxRecommendations":10,"queryParameters":{"query":"myQuery","facetFilters":["query1"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback1"]}},{"indexName":"indexName2","objectID":"objectID2","model":"related-products","threshold":21.7,"maxRecommendations":10,"queryParameters":{"query":"myQuery","facetFilters":["query2"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback2"]}}]}"""
    )
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
  }

  test("get frequently bought together recommendations7") {
    val (client, echo) = testClient()
    val future = client.getRecommendations(
      getRecommendationsParams = GetRecommendationsParams(
        requests = Seq(
          BoughtTogetherQuery(
            indexName = "indexName1",
            objectID = "objectID1",
            model = FbtModel.withName("bought-together"),
            threshold = 42.7
          )
        )
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/indexes/*/recommendations")
    assert(res.method == "POST")
    val expectedBody = parse(
      """{"requests":[{"indexName":"indexName1","objectID":"objectID1","model":"bought-together","threshold":42.7}]}"""
    )
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
  }

  test("searchRecommendRules") {
    val (client, echo) = testClient()
    val future = client.searchRecommendRules(
      indexName = "indexName",
      model = RecommendModels.withName("related-products")
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/indexes/indexName/related-products/recommend/rules/search")
    assert(res.method == "POST")
    val expectedBody = parse("""{}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
  }

}
