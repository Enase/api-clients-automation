/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
  * https://github.com/algolia/api-clients-automation. DO NOT EDIT.
  */
package algoliasearch.api

import algoliasearch.analytics.Direction._
import algoliasearch.analytics.ErrorBase
import algoliasearch.analytics.GetAverageClickPositionResponse
import algoliasearch.analytics.GetClickPositionsResponse
import algoliasearch.analytics.GetClickThroughRateResponse
import algoliasearch.analytics.GetConversationRateResponse
import algoliasearch.analytics.GetNoClickRateResponse
import algoliasearch.analytics.GetNoResultsRateResponse
import algoliasearch.analytics.GetSearchesCountResponse
import algoliasearch.analytics.GetSearchesNoClicksResponse
import algoliasearch.analytics.GetSearchesNoResultsResponse
import algoliasearch.analytics.GetStatusResponse
import algoliasearch.analytics.GetTopCountriesResponse
import algoliasearch.analytics.GetTopFilterAttributesResponse
import algoliasearch.analytics.GetTopFilterForAttributeResponse
import algoliasearch.analytics.GetTopFiltersNoResultsResponse
import algoliasearch.analytics.GetTopHitsResponse
import algoliasearch.analytics.GetTopSearchesResponse
import algoliasearch.analytics.GetUsersCountResponse
import algoliasearch.analytics.OrderBy._
import algoliasearch.analytics._
import algoliasearch.ApiClient
import algoliasearch.api.AnalyticsClient.hosts
import algoliasearch.config._
import algoliasearch.internal.util._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Random

object AnalyticsClient {

  /** Creates a new SearchApi instance using default hosts.
    *
    * @param appId
    *   application ID
    * @param apiKey
    *   api key
    * @param region
    *   region
    * @param clientOptions
    *   client options
    */
  def apply(
      appId: String,
      apiKey: String,
      region: Option[String] = None,
      clientOptions: ClientOptions = ClientOptions()
  ) = new AnalyticsClient(
    appId = appId,
    apiKey = apiKey,
    region = region,
    clientOptions = clientOptions
  )

  private def hosts(region: Option[String] = None): Seq[Host] = {
    val allowedRegions = Seq("de", "us")
    if (region.isDefined && !allowedRegions.contains(region.get)) {
      throw new IllegalArgumentException(s"`region` must be one of the following: ${allowedRegions.mkString(", ")}")
    }
    val url =
      if (region.isEmpty) "analytics.algolia.com" else "analytics.{region}.algolia.com".replace("{region}", region.get)
    Seq(Host(url = url, callTypes = Set(CallType.Read, CallType.Write)))
  }
}

class AnalyticsClient(
    appId: String,
    apiKey: String,
    region: Option[String] = None,
    clientOptions: ClientOptions = ClientOptions()
) extends ApiClient(
      appId = appId,
      apiKey = apiKey,
      clientName = "Analytics",
      defaultHosts = hosts(region),
      formats = JsonSupport.format,
      options = clientOptions
    ) {

  /** This method allow you to send requests to the Algolia REST API.
    *
    * @param path
    *   Path of the endpoint, anything after \"/1\" must be specified.
    * @param parameters
    *   Query parameters to apply to the current query.
    */
  def customDelete[T: Manifest](
      path: String,
      parameters: Option[Map[String, Any]] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[T] = Future {
    requireNotNull(path, "Parameter `path` is required when calling `customDelete`.")

    val request = HttpRequest
      .builder()
      .withMethod("DELETE")
      .withPath(s"/1${path}")
      .withQueryParameters(parameters)
      .build()
    execute[T](request, requestOptions)
  }

  /** This method allow you to send requests to the Algolia REST API.
    *
    * @param path
    *   Path of the endpoint, anything after \"/1\" must be specified.
    * @param parameters
    *   Query parameters to apply to the current query.
    */
  def customGet[T: Manifest](
      path: String,
      parameters: Option[Map[String, Any]] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[T] = Future {
    requireNotNull(path, "Parameter `path` is required when calling `customGet`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/1${path}")
      .withQueryParameters(parameters)
      .build()
    execute[T](request, requestOptions)
  }

  /** This method allow you to send requests to the Algolia REST API.
    *
    * @param path
    *   Path of the endpoint, anything after \"/1\" must be specified.
    * @param parameters
    *   Query parameters to apply to the current query.
    * @param body
    *   Parameters to send with the custom request.
    */
  def customPost[T: Manifest](
      path: String,
      parameters: Option[Map[String, Any]] = None,
      body: Option[Any] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[T] = Future {
    requireNotNull(path, "Parameter `path` is required when calling `customPost`.")

    val request = HttpRequest
      .builder()
      .withMethod("POST")
      .withPath(s"/1${path}")
      .withBody(body)
      .withQueryParameters(parameters)
      .build()
    execute[T](request, requestOptions)
  }

  /** This method allow you to send requests to the Algolia REST API.
    *
    * @param path
    *   Path of the endpoint, anything after \"/1\" must be specified.
    * @param parameters
    *   Query parameters to apply to the current query.
    * @param body
    *   Parameters to send with the custom request.
    */
  def customPut[T: Manifest](
      path: String,
      parameters: Option[Map[String, Any]] = None,
      body: Option[Any] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[T] = Future {
    requireNotNull(path, "Parameter `path` is required when calling `customPut`.")

    val request = HttpRequest
      .builder()
      .withMethod("PUT")
      .withPath(s"/1${path}")
      .withBody(body)
      .withQueryParameters(parameters)
      .build()
    execute[T](request, requestOptions)
  }

  /** Return the average click position for the complete time range and for individual days. > **Note**: If all
    * `positions` have a `clickCount` of `0` or `null`, it means Algolia didn't receive any click events for tracked
    * searches. A _tracked_ search is a search request where the `clickAnalytics` parameter is `true`.
    *
    * Required API Key ACLs:
    *   - analytics
    *
    * @param index
    *   Index name to target.
    * @param startDate
    *   Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param endDate
    *   End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param tags
    *   Filter analytics on the
    *   [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time.
    *   Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or
    *   parentheses, it must be URL-encoded.
    */
  def getAverageClickPosition(
      index: String,
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      tags: Option[String] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[GetAverageClickPositionResponse] = Future {
    requireNotNull(index, "Parameter `index` is required when calling `getAverageClickPosition`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/2/clicks/averageClickPosition")
      .withQueryParameter("index", index)
      .withQueryParameter("startDate", startDate)
      .withQueryParameter("endDate", endDate)
      .withQueryParameter("tags", tags)
      .build()
    execute[GetAverageClickPositionResponse](request, requestOptions)
  }

  /** Show the number of clicks events and their associated position in the search results. > **Note**: If all
    * `positions` have a `clickCount` of `0` or `null`, it means Algolia didn't receive any click events for tracked
    * searches. A _tracked_ search is a search request where the `clickAnalytics` parameter is `true`.
    *
    * Required API Key ACLs:
    *   - analytics
    *
    * @param index
    *   Index name to target.
    * @param startDate
    *   Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param endDate
    *   End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param tags
    *   Filter analytics on the
    *   [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time.
    *   Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or
    *   parentheses, it must be URL-encoded.
    */
  def getClickPositions(
      index: String,
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      tags: Option[String] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[GetClickPositionsResponse] = Future {
    requireNotNull(index, "Parameter `index` is required when calling `getClickPositions`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/2/clicks/positions")
      .withQueryParameter("index", index)
      .withQueryParameter("startDate", startDate)
      .withQueryParameter("endDate", endDate)
      .withQueryParameter("tags", tags)
      .build()
    execute[GetClickPositionsResponse](request, requestOptions)
  }

  /** Returns a [click-through rate
    * (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate).
    *
    * Required API Key ACLs:
    *   - analytics
    *
    * @param index
    *   Index name to target.
    * @param startDate
    *   Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param endDate
    *   End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param tags
    *   Filter analytics on the
    *   [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time.
    *   Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or
    *   parentheses, it must be URL-encoded.
    */
  def getClickThroughRate(
      index: String,
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      tags: Option[String] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[GetClickThroughRateResponse] = Future {
    requireNotNull(index, "Parameter `index` is required when calling `getClickThroughRate`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/2/clicks/clickThroughRate")
      .withQueryParameter("index", index)
      .withQueryParameter("startDate", startDate)
      .withQueryParameter("endDate", endDate)
      .withQueryParameter("tags", tags)
      .build()
    execute[GetClickThroughRateResponse](request, requestOptions)
  }

  /** Return a [conversion rate](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#conversion-rate).
    *
    * Required API Key ACLs:
    *   - analytics
    *
    * @param index
    *   Index name to target.
    * @param startDate
    *   Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param endDate
    *   End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param tags
    *   Filter analytics on the
    *   [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time.
    *   Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or
    *   parentheses, it must be URL-encoded.
    */
  def getConversationRate(
      index: String,
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      tags: Option[String] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[GetConversationRateResponse] = Future {
    requireNotNull(index, "Parameter `index` is required when calling `getConversationRate`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/2/conversions/conversionRate")
      .withQueryParameter("index", index)
      .withQueryParameter("startDate", startDate)
      .withQueryParameter("endDate", endDate)
      .withQueryParameter("tags", tags)
      .build()
    execute[GetConversationRateResponse](request, requestOptions)
  }

  /** Returns the rate at which searches don't lead to any clicks. The endpoint returns a value for the complete given
    * time range, as well as a value per day. It also returns the count of searches and searches without clicks.
    *
    * Required API Key ACLs:
    *   - analytics
    *
    * @param index
    *   Index name to target.
    * @param startDate
    *   Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param endDate
    *   End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param tags
    *   Filter analytics on the
    *   [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time.
    *   Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or
    *   parentheses, it must be URL-encoded.
    */
  def getNoClickRate(
      index: String,
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      tags: Option[String] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[GetNoClickRateResponse] = Future {
    requireNotNull(index, "Parameter `index` is required when calling `getNoClickRate`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/2/searches/noClickRate")
      .withQueryParameter("index", index)
      .withQueryParameter("startDate", startDate)
      .withQueryParameter("endDate", endDate)
      .withQueryParameter("tags", tags)
      .build()
    execute[GetNoClickRateResponse](request, requestOptions)
  }

  /** Returns the rate at which searches didn't return any results.
    *
    * Required API Key ACLs:
    *   - analytics
    *
    * @param index
    *   Index name to target.
    * @param startDate
    *   Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param endDate
    *   End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param tags
    *   Filter analytics on the
    *   [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time.
    *   Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or
    *   parentheses, it must be URL-encoded.
    */
  def getNoResultsRate(
      index: String,
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      tags: Option[String] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[GetNoResultsRateResponse] = Future {
    requireNotNull(index, "Parameter `index` is required when calling `getNoResultsRate`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/2/searches/noResultRate")
      .withQueryParameter("index", index)
      .withQueryParameter("startDate", startDate)
      .withQueryParameter("endDate", endDate)
      .withQueryParameter("tags", tags)
      .build()
    execute[GetNoResultsRateResponse](request, requestOptions)
  }

  /** Returns the number of searches within a time range.
    *
    * Required API Key ACLs:
    *   - analytics
    *
    * @param index
    *   Index name to target.
    * @param startDate
    *   Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param endDate
    *   End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param tags
    *   Filter analytics on the
    *   [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time.
    *   Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or
    *   parentheses, it must be URL-encoded.
    */
  def getSearchesCount(
      index: String,
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      tags: Option[String] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[GetSearchesCountResponse] = Future {
    requireNotNull(index, "Parameter `index` is required when calling `getSearchesCount`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/2/searches/count")
      .withQueryParameter("index", index)
      .withQueryParameter("startDate", startDate)
      .withQueryParameter("endDate", endDate)
      .withQueryParameter("tags", tags)
      .build()
    execute[GetSearchesCountResponse](request, requestOptions)
  }

  /** Return the most popular of the last 1,000 searches that didn't lead to any clicks.
    *
    * Required API Key ACLs:
    *   - analytics
    *
    * @param index
    *   Index name to target.
    * @param startDate
    *   Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param endDate
    *   End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param limit
    *   Number of records to return (page size).
    * @param offset
    *   Position of the starting record. Used for paging. 0 is the first record.
    * @param tags
    *   Filter analytics on the
    *   [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time.
    *   Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or
    *   parentheses, it must be URL-encoded.
    */
  def getSearchesNoClicks(
      index: String,
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      limit: Option[Int] = None,
      offset: Option[Int] = None,
      tags: Option[String] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[GetSearchesNoClicksResponse] = Future {
    requireNotNull(index, "Parameter `index` is required when calling `getSearchesNoClicks`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/2/searches/noClicks")
      .withQueryParameter("index", index)
      .withQueryParameter("startDate", startDate)
      .withQueryParameter("endDate", endDate)
      .withQueryParameter("limit", limit)
      .withQueryParameter("offset", offset)
      .withQueryParameter("tags", tags)
      .build()
    execute[GetSearchesNoClicksResponse](request, requestOptions)
  }

  /** Returns the most popular of the latest 1,000 searches that didn't return any results.
    *
    * Required API Key ACLs:
    *   - analytics
    *
    * @param index
    *   Index name to target.
    * @param startDate
    *   Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param endDate
    *   End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param limit
    *   Number of records to return (page size).
    * @param offset
    *   Position of the starting record. Used for paging. 0 is the first record.
    * @param tags
    *   Filter analytics on the
    *   [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time.
    *   Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or
    *   parentheses, it must be URL-encoded.
    */
  def getSearchesNoResults(
      index: String,
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      limit: Option[Int] = None,
      offset: Option[Int] = None,
      tags: Option[String] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[GetSearchesNoResultsResponse] = Future {
    requireNotNull(index, "Parameter `index` is required when calling `getSearchesNoResults`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/2/searches/noResults")
      .withQueryParameter("index", index)
      .withQueryParameter("startDate", startDate)
      .withQueryParameter("endDate", endDate)
      .withQueryParameter("limit", limit)
      .withQueryParameter("offset", offset)
      .withQueryParameter("tags", tags)
      .build()
    execute[GetSearchesNoResultsResponse](request, requestOptions)
  }

  /** Return the latest update time of the Analytics API for an index. If the index has been recently created or no
    * search has been performed yet, `updatedAt` will be `null`. > **Note**: The Analytics API is updated every
    * 5&nbsp;minutes.
    *
    * Required API Key ACLs:
    *   - analytics
    *
    * @param index
    *   Index name to target.
    */
  def getStatus(index: String, requestOptions: Option[RequestOptions] = None)(implicit
      ec: ExecutionContext
  ): Future[GetStatusResponse] = Future {
    requireNotNull(index, "Parameter `index` is required when calling `getStatus`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/2/status")
      .withQueryParameter("index", index)
      .build()
    execute[GetStatusResponse](request, requestOptions)
  }

  /** Returns top countries. Limited to the 1,000 most frequent ones.
    *
    * Required API Key ACLs:
    *   - analytics
    *
    * @param index
    *   Index name to target.
    * @param startDate
    *   Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param endDate
    *   End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param limit
    *   Number of records to return (page size).
    * @param offset
    *   Position of the starting record. Used for paging. 0 is the first record.
    * @param tags
    *   Filter analytics on the
    *   [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time.
    *   Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or
    *   parentheses, it must be URL-encoded.
    */
  def getTopCountries(
      index: String,
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      limit: Option[Int] = None,
      offset: Option[Int] = None,
      tags: Option[String] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[GetTopCountriesResponse] = Future {
    requireNotNull(index, "Parameter `index` is required when calling `getTopCountries`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/2/countries")
      .withQueryParameter("index", index)
      .withQueryParameter("startDate", startDate)
      .withQueryParameter("endDate", endDate)
      .withQueryParameter("limit", limit)
      .withQueryParameter("offset", offset)
      .withQueryParameter("tags", tags)
      .build()
    execute[GetTopCountriesResponse](request, requestOptions)
  }

  /** Return the most popular [filterable
    * attributes](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/) in the 1,000 most
    * recently used filters.
    *
    * Required API Key ACLs:
    *   - analytics
    *
    * @param index
    *   Index name to target.
    * @param search
    *   User query.
    * @param startDate
    *   Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param endDate
    *   End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param limit
    *   Number of records to return (page size).
    * @param offset
    *   Position of the starting record. Used for paging. 0 is the first record.
    * @param tags
    *   Filter analytics on the
    *   [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time.
    *   Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or
    *   parentheses, it must be URL-encoded.
    */
  def getTopFilterAttributes(
      index: String,
      search: Option[String] = None,
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      limit: Option[Int] = None,
      offset: Option[Int] = None,
      tags: Option[String] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[GetTopFilterAttributesResponse] = Future {
    requireNotNull(index, "Parameter `index` is required when calling `getTopFilterAttributes`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/2/filters")
      .withQueryParameter("index", index)
      .withQueryParameter("search", search)
      .withQueryParameter("startDate", startDate)
      .withQueryParameter("endDate", endDate)
      .withQueryParameter("limit", limit)
      .withQueryParameter("offset", offset)
      .withQueryParameter("tags", tags)
      .build()
    execute[GetTopFilterAttributesResponse](request, requestOptions)
  }

  /** Returns the most popular filter values for an attribute in the 1,000 most recently used filters.
    *
    * Required API Key ACLs:
    *   - analytics
    *
    * @param attribute
    *   Attribute name.
    * @param index
    *   Index name to target.
    * @param search
    *   User query.
    * @param startDate
    *   Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param endDate
    *   End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param limit
    *   Number of records to return (page size).
    * @param offset
    *   Position of the starting record. Used for paging. 0 is the first record.
    * @param tags
    *   Filter analytics on the
    *   [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time.
    *   Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or
    *   parentheses, it must be URL-encoded.
    */
  def getTopFilterForAttribute(
      attribute: String,
      index: String,
      search: Option[String] = None,
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      limit: Option[Int] = None,
      offset: Option[Int] = None,
      tags: Option[String] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[GetTopFilterForAttributeResponse] = Future {
    requireNotNull(attribute, "Parameter `attribute` is required when calling `getTopFilterForAttribute`.")
    requireNotNull(index, "Parameter `index` is required when calling `getTopFilterForAttribute`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/2/filters/${escape(attribute)}")
      .withQueryParameter("index", index)
      .withQueryParameter("search", search)
      .withQueryParameter("startDate", startDate)
      .withQueryParameter("endDate", endDate)
      .withQueryParameter("limit", limit)
      .withQueryParameter("offset", offset)
      .withQueryParameter("tags", tags)
      .build()
    execute[GetTopFilterForAttributeResponse](request, requestOptions)
  }

  /** Returns top filters for filter-enabled searches that don't return results. Limited to the 1,000 most recently used
    * filters.
    *
    * Required API Key ACLs:
    *   - analytics
    *
    * @param index
    *   Index name to target.
    * @param search
    *   User query.
    * @param startDate
    *   Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param endDate
    *   End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param limit
    *   Number of records to return (page size).
    * @param offset
    *   Position of the starting record. Used for paging. 0 is the first record.
    * @param tags
    *   Filter analytics on the
    *   [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time.
    *   Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or
    *   parentheses, it must be URL-encoded.
    */
  def getTopFiltersNoResults(
      index: String,
      search: Option[String] = None,
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      limit: Option[Int] = None,
      offset: Option[Int] = None,
      tags: Option[String] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[GetTopFiltersNoResultsResponse] = Future {
    requireNotNull(index, "Parameter `index` is required when calling `getTopFiltersNoResults`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/2/filters/noResults")
      .withQueryParameter("index", index)
      .withQueryParameter("search", search)
      .withQueryParameter("startDate", startDate)
      .withQueryParameter("endDate", endDate)
      .withQueryParameter("limit", limit)
      .withQueryParameter("offset", offset)
      .withQueryParameter("tags", tags)
      .build()
    execute[GetTopFiltersNoResultsResponse](request, requestOptions)
  }

  /** Return the most popular clicked results in the last 1,000 searches.
    *
    * Required API Key ACLs:
    *   - analytics
    *
    * @param index
    *   Index name to target.
    * @param search
    *   User query.
    * @param clickAnalytics
    *   Whether to include [click and conversion](https://www.algolia.com/doc/guides/sending-events/getting-started/)
    *   rates for a search.
    * @param startDate
    *   Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param endDate
    *   End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param limit
    *   Number of records to return (page size).
    * @param offset
    *   Position of the starting record. Used for paging. 0 is the first record.
    * @param tags
    *   Filter analytics on the
    *   [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time.
    *   Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or
    *   parentheses, it must be URL-encoded.
    */
  def getTopHits(
      index: String,
      search: Option[String] = None,
      clickAnalytics: Option[Boolean] = None,
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      limit: Option[Int] = None,
      offset: Option[Int] = None,
      tags: Option[String] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[GetTopHitsResponse] = Future {
    requireNotNull(index, "Parameter `index` is required when calling `getTopHits`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/2/hits")
      .withQueryParameter("index", index)
      .withQueryParameter("search", search)
      .withQueryParameter("clickAnalytics", clickAnalytics)
      .withQueryParameter("startDate", startDate)
      .withQueryParameter("endDate", endDate)
      .withQueryParameter("limit", limit)
      .withQueryParameter("offset", offset)
      .withQueryParameter("tags", tags)
      .build()
    execute[GetTopHitsResponse](request, requestOptions)
  }

  /** Returns the most popular of the latest 1,000 searches. For each search, also returns the number of hits.
    *
    * Required API Key ACLs:
    *   - analytics
    *
    * @param index
    *   Index name to target.
    * @param clickAnalytics
    *   Whether to include [click and conversion](https://www.algolia.com/doc/guides/sending-events/getting-started/)
    *   rates for a search.
    * @param startDate
    *   Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param endDate
    *   End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param orderBy
    *   Reorder the results.
    * @param direction
    *   Sorting direction of the results: ascending or descending.
    * @param limit
    *   Number of records to return (page size).
    * @param offset
    *   Position of the starting record. Used for paging. 0 is the first record.
    * @param tags
    *   Filter analytics on the
    *   [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time.
    *   Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or
    *   parentheses, it must be URL-encoded.
    */
  def getTopSearches(
      index: String,
      clickAnalytics: Option[Boolean] = None,
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      orderBy: Option[OrderBy] = None,
      direction: Option[Direction] = None,
      limit: Option[Int] = None,
      offset: Option[Int] = None,
      tags: Option[String] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[GetTopSearchesResponse] = Future {
    requireNotNull(index, "Parameter `index` is required when calling `getTopSearches`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/2/searches")
      .withQueryParameter("index", index)
      .withQueryParameter("clickAnalytics", clickAnalytics)
      .withQueryParameter("startDate", startDate)
      .withQueryParameter("endDate", endDate)
      .withQueryParameter("orderBy", orderBy)
      .withQueryParameter("direction", direction)
      .withQueryParameter("limit", limit)
      .withQueryParameter("offset", offset)
      .withQueryParameter("tags", tags)
      .build()
    execute[GetTopSearchesResponse](request, requestOptions)
  }

  /** Return the count of unique users.
    *
    * Required API Key ACLs:
    *   - analytics
    *
    * @param index
    *   Index name to target.
    * @param startDate
    *   Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param endDate
    *   End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
    * @param tags
    *   Filter analytics on the
    *   [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time.
    *   Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or
    *   parentheses, it must be URL-encoded.
    */
  def getUsersCount(
      index: String,
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      tags: Option[String] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[GetUsersCountResponse] = Future {
    requireNotNull(index, "Parameter `index` is required when calling `getUsersCount`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/2/users/count")
      .withQueryParameter("index", index)
      .withQueryParameter("startDate", startDate)
      .withQueryParameter("endDate", endDate)
      .withQueryParameter("tags", tags)
      .build()
    execute[GetUsersCountResponse](request, requestOptions)
  }

}
