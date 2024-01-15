/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.insights

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Use this event to track when users click facet filters in your user interface.
 *
 * @param eventName The name of the event, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework.
 * @param eventType
 * @param index The name of an Algolia index.
 * @param filters Facet filters.  Each facet filter string must be URL-encoded, such as, `discount:10%25`.
 * @param userToken An anonymous or pseudonymous user identifier.  > **Note**: Never include personally identifiable information in user tokens.
 * @param authenticatedUserToken An identifier for authenticated users.  > **Note**: Never include personally identifiable information in user tokens.
 * @param timestamp The timestamp of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp.
 */
@Serializable
public data class ClickedFilters(

  /** The name of the event, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework.  */
  @SerialName(value = "eventName") val eventName: String,

  @SerialName(value = "eventType") val eventType: ClickEvent,

  /** The name of an Algolia index. */
  @SerialName(value = "index") val index: String,

  /** Facet filters.  Each facet filter string must be URL-encoded, such as, `discount:10%25`.  */
  @SerialName(value = "filters") val filters: List<String>,

  /** An anonymous or pseudonymous user identifier.  > **Note**: Never include personally identifiable information in user tokens.  */
  @SerialName(value = "userToken") val userToken: String,

  /** An identifier for authenticated users.  > **Note**: Never include personally identifiable information in user tokens.  */
  @SerialName(value = "authenticatedUserToken") val authenticatedUserToken: String? = null,

  /** The timestamp of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp.  */
  @SerialName(value = "timestamp") val timestamp: Long? = null,
) : EventsItems
