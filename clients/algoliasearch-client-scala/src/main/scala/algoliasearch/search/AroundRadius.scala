/** Search API Use the Search REST API to manage your data (indices and records), implement search, and improve
  * relevance (with Rules, synonyms, and language dictionaries). Although Algolia provides a REST API, you should use
  * the official open source API [clients, libraries, and
  * tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no
  * [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.
  *
  * The version of the OpenAPI document: 1.0.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.search

import algoliasearch.search.AroundRadiusAll._

import org.json4s._

/** [Maximum
  * radius](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#increase-the-search-radius)
  * for a geographical search (in meters).
  */
sealed trait AroundRadius

trait AroundRadiusTrait extends AroundRadius

object AroundRadius {

  case class IntValue(value: Int) extends AroundRadius

  def apply(value: Int): AroundRadius = {
    AroundRadius.IntValue(value)
  }
}

object AroundRadiusSerializer extends Serializer[AroundRadius] {
  override def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), AroundRadius] = {

    case (TypeInfo(clazz, _), json) if clazz == classOf[AroundRadius] =>
      json match {
        case JInt(value)    => AroundRadius.IntValue(value.toInt)
        case value: JString => Extraction.extract[AroundRadiusAll](value)
        case _              => throw new MappingException("Can't convert " + json + " to AroundRadius")
      }
  }

  override def serialize(implicit format: Formats): PartialFunction[Any, JValue] = { case value: AroundRadius =>
    value match {
      case AroundRadius.IntValue(value) => JInt(value)
      case value: AroundRadiusAll       => JString(value.toString)
    }
  }
}
