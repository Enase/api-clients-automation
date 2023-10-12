/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import com.algolia.client.exception.AlgoliaClientException
import com.algolia.client.extensions.internal.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.json.*
import kotlin.jvm.JvmInline

/**
 * MixedSearchFilters
 *
 * Implementations:
 * - [List<String>] - *[MixedSearchFilters.of]*
 * - [String] - *[MixedSearchFilters.of]*
 */
@Serializable(MixedSearchFiltersSerializer::class)
public sealed interface MixedSearchFilters {

  @JvmInline
  public value class ListOfStringValue(public val value: List<String>) : MixedSearchFilters

  @JvmInline
  public value class StringValue(public val value: String) : MixedSearchFilters

  public companion object {

    /** [MixedSearchFilters] as [List<String>] Value. */
    public fun of(value: List<String>): MixedSearchFilters {
      return ListOfStringValue(value)
    }

    /** [MixedSearchFilters] as [String] Value. */
    public fun of(value: String): MixedSearchFilters {
      return StringValue(value)
    }
  }
}

internal class MixedSearchFiltersSerializer : KSerializer<MixedSearchFilters> {

  override val descriptor: SerialDescriptor = buildClassSerialDescriptor("MixedSearchFilters")

  override fun serialize(encoder: Encoder, value: MixedSearchFilters) {
    when (value) {
      is MixedSearchFilters.ListOfStringValue -> ListSerializer(String.serializer()).serialize(encoder, value.value)
      is MixedSearchFilters.StringValue -> String.serializer().serialize(encoder, value.value)
    }
  }

  override fun deserialize(decoder: Decoder): MixedSearchFilters {
    val codec = decoder.asJsonDecoder()
    val tree = codec.decodeJsonElement()

    // deserialize List<String>
    if (tree is JsonArray) {
      try {
        val value = codec.json.decodeFromJsonElement(ListSerializer(String.serializer()), tree)
        return MixedSearchFilters.of(value)
      } catch (e: Exception) {
        // deserialization failed, continue
        println("Failed to deserialize List<String> (error: ${e.message})")
      }
    }

    // deserialize String
    if (tree is JsonPrimitive) {
      try {
        val value = codec.json.decodeFromJsonElement(String.serializer(), tree)
        return MixedSearchFilters.of(value)
      } catch (e: Exception) {
        // deserialization failed, continue
        println("Failed to deserialize String (error: ${e.message})")
      }
    }

    throw AlgoliaClientException("Failed to deserialize json element: $tree")
  }
}
