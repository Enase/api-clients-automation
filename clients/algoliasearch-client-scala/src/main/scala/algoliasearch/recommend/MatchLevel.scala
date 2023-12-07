/** Recommend API The Recommend API lets you generate recommendations with several AI models. > **Note**: You should use
  * Algolia's [libraries and
  * tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) to interact with
  * the Recommend API. Using the HTTP endpoints directly is not covered by the
  * [SLA](https://www.algolia.com/policies/sla/).
  *
  * The version of the OpenAPI document: 1.0.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.recommend

import org.json4s._

sealed trait MatchLevel

/** Indicates how well the attribute matched the search query.
  */
object MatchLevel {
  case object None extends MatchLevel {
    override def toString = "none"
  }
  case object Partial extends MatchLevel {
    override def toString = "partial"
  }
  case object Full extends MatchLevel {
    override def toString = "full"
  }
  val values: Seq[MatchLevel] = Seq(None, Partial, Full)

  def withName(name: String): MatchLevel = MatchLevel.values
    .find(_.toString == name)
    .getOrElse(throw new MappingException(s"Unknown MatchLevel value: $name"))
}

class MatchLevelSerializer
    extends CustomSerializer[MatchLevel](_ =>
      (
        {
          case JString(value) => MatchLevel.withName(value)
          case JNull          => null
        },
        { case value: MatchLevel =>
          JString(value.toString)
        }
      )
    )
