/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.recommend

import com.algolia.client.exception.AlgoliaClientException
import com.algolia.client.extensions.internal.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.json.*
import kotlin.jvm.JvmInline

/**
 * Names of facets to which automatic filtering must be applied; they must match the facet name of a facet value placeholder in the query pattern.
 *
 * Implementations:
 * - [List<AutomaticFacetFilter>] - *[AutomaticFacetFilters.ofListOfAutomaticFacetFilter]*
 * - [List<String>] - *[AutomaticFacetFilters.ofListOfString]*
 */
@Serializable(AutomaticFacetFiltersSerializer::class)
public sealed interface AutomaticFacetFilters {

  @JvmInline
  public value class ListOfAutomaticFacetFilterValue(public val value: List<AutomaticFacetFilter>) : AutomaticFacetFilters

  @JvmInline
  public value class ListOfStringValue(public val value: List<String>) : AutomaticFacetFilters

  public companion object {

    /** [AutomaticFacetFilters] as [List<AutomaticFacetFilter>] Value. */
    public fun ofListOfAutomaticFacetFilter(value: List<AutomaticFacetFilter>): AutomaticFacetFilters {
      return ListOfAutomaticFacetFilterValue(value)
    }

    /** [AutomaticFacetFilters] as [List<String>] Value. */
    public fun ofListOfString(value: List<String>): AutomaticFacetFilters {
      return ListOfStringValue(value)
    }
  }
}

internal class AutomaticFacetFiltersSerializer : KSerializer<AutomaticFacetFilters> {

  override val descriptor: SerialDescriptor = buildClassSerialDescriptor("AutomaticFacetFilters")

  override fun serialize(encoder: Encoder, value: AutomaticFacetFilters) {
    when (value) {
      is AutomaticFacetFilters.ListOfAutomaticFacetFilterValue -> ListSerializer(AutomaticFacetFilter.serializer()).serialize(encoder, value.value)
      is AutomaticFacetFilters.ListOfStringValue -> ListSerializer(String.serializer()).serialize(encoder, value.value)
    }
  }

  override fun deserialize(decoder: Decoder): AutomaticFacetFilters {
    val codec = decoder.asJsonDecoder()
    val tree = codec.decodeJsonElement()

    // deserialize List<AutomaticFacetFilter>
    if (tree is JsonArray) {
      try {
        val value = codec.json.decodeFromJsonElement(ListSerializer(AutomaticFacetFilter.serializer()), tree)
        return AutomaticFacetFilters.ofListOfAutomaticFacetFilter(value)
      } catch (e: Exception) {
        // deserialization failed, continue
        println("Failed to deserialize List<AutomaticFacetFilter> (error: ${e.message})")
      }
    }

    // deserialize List<String>
    if (tree is JsonArray) {
      try {
        val value = codec.json.decodeFromJsonElement(ListSerializer(String.serializer()), tree)
        return AutomaticFacetFilters.ofListOfString(value)
      } catch (e: Exception) {
        // deserialization failed, continue
        println("Failed to deserialize List<String> (error: ${e.message})")
      }
    }

    throw AlgoliaClientException("Failed to deserialize json element: $tree")
  }
}
