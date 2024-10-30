/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*

/**
 * Type of authentication. This determines the type of credentials required in the `input` object.
 */
@Serializable
public enum class AuthenticationType(public val value: kotlin.String) {

  @SerialName(value = "googleServiceAccount")
  GoogleServiceAccount("googleServiceAccount"),

  @SerialName(value = "basic")
  Basic("basic"),

  @SerialName(value = "apiKey")
  ApiKey("apiKey"),

  @SerialName(value = "oauth")
  Oauth("oauth"),

  @SerialName(value = "algolia")
  Algolia("algolia"),

  @SerialName(value = "algoliaInsights")
  AlgoliaInsights("algoliaInsights"),

  @SerialName(value = "secrets")
  Secrets("secrets");

  override fun toString(): kotlin.String = value
}
