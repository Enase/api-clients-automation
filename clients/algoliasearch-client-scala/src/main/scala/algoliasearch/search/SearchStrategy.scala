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

import org.json4s._

sealed trait SearchStrategy

/**   - `none`: executes all queries. - `stopIfEnoughMatches`: executes queries one by one, stopping further query
  *     execution as soon as a query matches at least the `hitsPerPage` number of results.
  */
object SearchStrategy {
  case object None extends SearchStrategy {
    override def toString = "none"
  }
  case object StopIfEnoughMatches extends SearchStrategy {
    override def toString = "stopIfEnoughMatches"
  }
  val values: Seq[SearchStrategy] = Seq(None, StopIfEnoughMatches)

  def withName(name: String): SearchStrategy = SearchStrategy.values
    .find(_.toString == name)
    .getOrElse(throw new MappingException(s"Unknown SearchStrategy value: $name"))
}

class SearchStrategySerializer
    extends CustomSerializer[SearchStrategy](_ =>
      (
        {
          case JString(value) => SearchStrategy.withName(value)
          case JNull          => null
        },
        { case value: SearchStrategy =>
          JString(value.toString)
        }
      )
    )
