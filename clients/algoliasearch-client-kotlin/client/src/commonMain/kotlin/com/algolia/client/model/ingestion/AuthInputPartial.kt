/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import com.algolia.client.exception.AlgoliaClientException
import com.algolia.client.extensions.internal.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.json.*
import kotlin.jvm.JvmInline

/**
 * AuthInputPartial
 *
 * Implementations:
 * - [AuthAPIKeyPartial]
 * - [AuthAlgoliaInsightsPartial]
 * - [AuthAlgoliaPartial]
 * - [AuthBasicPartial]
 * - [AuthGoogleServiceAccountPartial]
 * - [AuthOAuthPartial]
 * - [Map<kotlin.String, String>] - *[AuthInputPartial.of]*
 */
@Serializable(AuthInputPartialSerializer::class)
public sealed interface AuthInputPartial {
  @Serializable
  @JvmInline
  public value class AuthGoogleServiceAccountPartialValue(public val value: AuthGoogleServiceAccountPartial) : AuthInputPartial

  @Serializable
  @JvmInline
  public value class AuthBasicPartialValue(public val value: AuthBasicPartial) : AuthInputPartial

  @Serializable
  @JvmInline
  public value class AuthAPIKeyPartialValue(public val value: AuthAPIKeyPartial) : AuthInputPartial

  @Serializable
  @JvmInline
  public value class AuthOAuthPartialValue(public val value: AuthOAuthPartial) : AuthInputPartial

  @Serializable
  @JvmInline
  public value class AuthAlgoliaPartialValue(public val value: AuthAlgoliaPartial) : AuthInputPartial

  @Serializable
  @JvmInline
  public value class AuthAlgoliaInsightsPartialValue(public val value: AuthAlgoliaInsightsPartial) : AuthInputPartial

  @Serializable
  @JvmInline
  public value class MapOfkotlinStringStringValue(public val value: Map<kotlin.String, String>) : AuthInputPartial

  public companion object {

    public fun of(value: AuthGoogleServiceAccountPartial): AuthInputPartial = AuthGoogleServiceAccountPartialValue(value)

    public fun of(value: AuthBasicPartial): AuthInputPartial = AuthBasicPartialValue(value)

    public fun of(value: AuthAPIKeyPartial): AuthInputPartial = AuthAPIKeyPartialValue(value)

    public fun of(value: AuthOAuthPartial): AuthInputPartial = AuthOAuthPartialValue(value)

    public fun of(value: AuthAlgoliaPartial): AuthInputPartial = AuthAlgoliaPartialValue(value)

    public fun of(value: AuthAlgoliaInsightsPartial): AuthInputPartial = AuthAlgoliaInsightsPartialValue(value)

    public fun of(value: Map<kotlin.String, String>): AuthInputPartial = MapOfkotlinStringStringValue(value)
  }
}

internal class AuthInputPartialSerializer : JsonContentPolymorphicSerializer<AuthInputPartial>(AuthInputPartial::class) {
  override fun selectDeserializer(element: JsonElement): DeserializationStrategy<AuthInputPartial> = when {
    element is JsonObject && element.containsKey("clientEmail") -> AuthGoogleServiceAccountPartial.serializer()
    element is JsonObject && element.containsKey("username") -> AuthBasicPartial.serializer()
    element is JsonObject && element.containsKey("key") -> AuthAPIKeyPartial.serializer()
    element is JsonObject && element.containsKey("url") -> AuthOAuthPartial.serializer()
    element is JsonObject -> AuthAlgoliaPartial.serializer()
    element is JsonObject -> AuthAlgoliaInsightsPartial.serializer()
    element is JsonObject -> AuthInputPartial.MapOfkotlinStringStringValue.serializer()
    else -> throw AlgoliaClientException("Failed to deserialize json element: $element")
  }
}
