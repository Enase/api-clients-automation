// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element
import 'package:algoliasearch/src/model/advanced_syntax_features.dart';
import 'package:algoliasearch/src/model/supported_language.dart';
import 'package:algoliasearch/src/model/rendering_content.dart';
import 'package:algoliasearch/src/model/remove_words_if_no_results.dart';
import 'package:algoliasearch/src/model/query_type.dart';
import 'package:algoliasearch/src/model/exact_on_single_word_query.dart';
import 'package:algoliasearch/src/model/semantic_search.dart';
import 'package:algoliasearch/src/model/mode.dart';
import 'package:algoliasearch/src/model/alternatives_as_exact.dart';

import 'package:json_annotation/json_annotation.dart';

part 'consequence_params.g.dart';

@JsonSerializable()
final class ConsequenceParams {
  /// Returns a new [ConsequenceParams] instance.
  const ConsequenceParams({
    this.similarQuery,
    this.filters,
    this.facetFilters,
    this.optionalFilters,
    this.numericFilters,
    this.tagFilters,
    this.sumOrFiltersScores,
    this.restrictSearchableAttributes,
    this.facets,
    this.facetingAfterDistinct,
    this.page,
    this.offset,
    this.length,
    this.aroundLatLng,
    this.aroundLatLngViaIP,
    this.aroundRadius,
    this.aroundPrecision,
    this.minimumAroundRadius,
    this.insideBoundingBox,
    this.insidePolygon,
    this.naturalLanguages,
    this.ruleContexts,
    this.personalizationImpact,
    this.userToken,
    this.getRankingInfo,
    this.synonyms,
    this.clickAnalytics,
    this.analytics,
    this.analyticsTags,
    this.percentileComputation,
    this.enableABTest,
    this.attributesToRetrieve,
    this.ranking,
    this.customRanking,
    this.relevancyStrictness,
    this.attributesToHighlight,
    this.attributesToSnippet,
    this.highlightPreTag,
    this.highlightPostTag,
    this.snippetEllipsisText,
    this.restrictHighlightAndSnippetArrays,
    this.hitsPerPage,
    this.minWordSizefor1Typo,
    this.minWordSizefor2Typos,
    this.typoTolerance,
    this.allowTyposOnNumericTokens,
    this.disableTypoToleranceOnAttributes,
    this.ignorePlurals,
    this.removeStopWords,
    this.keepDiacriticsOnCharacters,
    this.queryLanguages,
    this.decompoundQuery,
    this.enableRules,
    this.enablePersonalization,
    this.queryType,
    this.removeWordsIfNoResults,
    this.mode,
    this.semanticSearch,
    this.advancedSyntax,
    this.optionalWords,
    this.disableExactOnAttributes,
    this.exactOnSingleWordQuery,
    this.alternativesAsExact,
    this.advancedSyntaxFeatures,
    this.distinct,
    this.replaceSynonymsInHighlight,
    this.minProximity,
    this.responseFields,
    this.maxFacetHits,
    this.maxValuesPerFacet,
    this.sortFacetValuesBy,
    this.attributeCriteriaComputedByMinProximity,
    this.renderingContent,
    this.enableReRanking,
    this.reRankingApplyFilter,
    this.query,
    this.automaticFacetFilters,
    this.automaticOptionalFacetFilters,
  });

  /// Keywords to be used instead of the search query to conduct a more broader search.  Using the `similarQuery` parameter changes other settings:  - `queryType` is set to `prefixNone`. - `removeStopWords` is set to true. - `words` is set as the first ranking criterion. - All remaining words are treated as `optionalWords`.  Since the `similarQuery` is supposed to do a broad search, they usually return many results. Combine it with `filters` to narrow down the list of results.
  @JsonKey(name: r'similarQuery')
  final String? similarQuery;

  /// Filter expression to only include items that match the filter criteria in the response.  You can use these filter expressions:  - **Numeric filters.** `<facet> <op> <number>`, where `<op>` is one of `<`, `<=`, `=`, `!=`, `>`, `>=`. - **Ranges.** `<facet>:<lower> TO <upper>` where `<lower>` and `<upper>` are the lower and upper limits of the range (inclusive). - **Facet filters.** `<facet>:<value>` where `<facet>` is a facet attribute (case-sensitive) and `<value>` a facet value. - **Tag filters.** `_tags:<value>` or just `<value>` (case-sensitive). - **Boolean filters.** `<facet>: true | false`.  You can combine filters with `AND`, `OR`, and `NOT` operators with the following restrictions:  - You can only combine filters of the same type with `OR`.   **Not supported:** `facet:value OR num > 3`. - You can't use `NOT` with combinations of filters.   **Not supported:** `NOT(facet:value OR facet:value)` - You can't combine conjunctions (`AND`) with `OR`.   **Not supported:** `facet:value OR (facet:value AND facet:value)`  Use quotes around your filters, if the facet attribute name or facet value has spaces, keywords (`OR`, `AND`, `NOT`), or quotes. If a facet attribute is an array, the filter matches if it matches at least one element of the array.  For more information, see [Filters](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/).
  @JsonKey(name: r'filters')
  final String? filters;

  /// One of types:
  /// - [List<List<FacetFilters>>]
  /// - [String]
  /// - [List<String>]
  @JsonKey(name: r'facetFilters')
  final dynamic facetFilters;

  /// One of types:
  /// - [String]
  /// - [List<List<OptionalFilters>>]
  /// - [List<String>]
  @JsonKey(name: r'optionalFilters')
  final dynamic optionalFilters;

  /// One of types:
  /// - [List<List<NumericFilters>>]
  /// - [String]
  /// - [List<String>]
  @JsonKey(name: r'numericFilters')
  final dynamic numericFilters;

  /// One of types:
  /// - [List<List<TagFilters>>]
  /// - [String]
  /// - [List<String>]
  @JsonKey(name: r'tagFilters')
  final dynamic tagFilters;

  /// Whether to sum all filter scores.  If true, all filter scores are summed. Otherwise, the maximum filter score is kept. For more information, see [filter scores](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/in-depth/filter-scoring/#accumulating-scores-with-sumorfiltersscores).
  @JsonKey(name: r'sumOrFiltersScores')
  final bool? sumOrFiltersScores;

  /// Restricts a search to a subset of your searchable attributes. Attribute names are case-sensitive.
  @JsonKey(name: r'restrictSearchableAttributes')
  final List<String>? restrictSearchableAttributes;

  /// Facets for which to retrieve facet values that match the search criteria and the number of matching facet values.  To retrieve all facets, use the wildcard character `*`. For more information, see [facets](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#contextual-facet-values-and-counts).
  @JsonKey(name: r'facets')
  final List<String>? facets;

  /// Whether faceting should be applied after deduplication with `distinct`.  This leads to accurate facet counts when using faceting in combination with `distinct`. It's usually better to use `afterDistinct` modifiers in the `attributesForFaceting` setting, as `facetingAfterDistinct` only computes correct facet counts if all records have the same facet values for the `attributeForDistinct`.
  @JsonKey(name: r'facetingAfterDistinct')
  final bool? facetingAfterDistinct;

  /// Page of search results to retrieve.
  // minimum: 0
  @JsonKey(name: r'page')
  final int? page;

  /// Position of the first hit to retrieve.
  @JsonKey(name: r'offset')
  final int? offset;

  /// Number of hits to retrieve (used in combination with `offset`).
  // minimum: 0
  // maximum: 1000
  @JsonKey(name: r'length')
  final int? length;

  /// Coordinates for the center of a circle, expressed as a comma-separated string of latitude and longitude.  Only records included within a circle around this central location are included in the results. The radius of the circle is determined by the `aroundRadius` and `minimumAroundRadius` settings. This parameter is ignored if you also specify `insidePolygon` or `insideBoundingBox`.
  @JsonKey(name: r'aroundLatLng')
  final String? aroundLatLng;

  /// Whether to obtain the coordinates from the request's IP address.
  @JsonKey(name: r'aroundLatLngViaIP')
  final bool? aroundLatLngViaIP;

  /// One of types:
  /// - [AroundRadiusAll]
  /// - [int]
  @JsonKey(name: r'aroundRadius')
  final dynamic aroundRadius;

  /// One of types:
  /// - [List<Range>]
  /// - [int]
  @JsonKey(name: r'aroundPrecision')
  final dynamic aroundPrecision;

  /// Minimum radius (in meters) for a search around a location when `aroundRadius` isn't set.
  // minimum: 1
  @JsonKey(name: r'minimumAroundRadius')
  final int? minimumAroundRadius;

  /// Coordinates for a rectangular area in which to search.  Each bounding box is defined by the two opposite points of its diagonal, and expressed as latitude and longitude pair: `[p1 lat, p1 long, p2 lat, p2 long]`. Provide multiple bounding boxes as nested arrays. For more information, see [rectangular area](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas).
  @JsonKey(name: r'insideBoundingBox')
  final List<List<double>>? insideBoundingBox;

  /// Coordinates of a polygon in which to search.  Polygons are defined by 3 to 10,000 points. Each point is represented by its latitude and longitude. Provide multiple polygons as nested arrays. For more information, see [filtering inside polygons](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas). This parameter is ignored if you also specify `insideBoundingBox`.
  @JsonKey(name: r'insidePolygon')
  final List<List<double>>? insidePolygon;

  /// ISO language codes that adjust settings that are useful for processing natural language queries (as opposed to keyword searches):  - Sets `removeStopWords` and `ignorePlurals` to the list of provided languages. - Sets `removeWordsIfNoResults` to `allOptional`. - Adds a `natural_language` attribute to `ruleContexts` and `analyticsTags`.
  @JsonKey(name: r'naturalLanguages')
  final List<SupportedLanguage>? naturalLanguages;

  /// Assigns a rule context to the search query.  [Rule contexts](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#whats-a-context) are strings that you can use to trigger matching rules.
  @JsonKey(name: r'ruleContexts')
  final List<String>? ruleContexts;

  /// Impact that Personalization should have on this search.  The higher this value is, the more Personalization determines the ranking compared to other factors. For more information, see [Understanding Personalization impact](https://www.algolia.com/doc/guides/personalization/personalizing-results/in-depth/configuring-personalization/#understanding-personalization-impact).
  // minimum: 0
  // maximum: 100
  @JsonKey(name: r'personalizationImpact')
  final int? personalizationImpact;

  /// Unique pseudonymous or anonymous user identifier.  This helps with analytics and click and conversion events. For more information, see [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).
  @JsonKey(name: r'userToken')
  final String? userToken;

  /// Whether the search response should include detailed ranking information.
  @JsonKey(name: r'getRankingInfo')
  final bool? getRankingInfo;

  /// Whether to take into account an index's synonyms for this search.
  @JsonKey(name: r'synonyms')
  final bool? synonyms;

  /// Whether to include a `queryID` attribute in the response.  The query ID is a unique identifier for a search query and is required for tracking [click and conversion events](https://www.algolia.com/guides/sending-events/getting-started/).
  @JsonKey(name: r'clickAnalytics')
  final bool? clickAnalytics;

  /// Whether this search will be included in Analytics.
  @JsonKey(name: r'analytics')
  final bool? analytics;

  /// Tags to apply to the query for [segmenting analytics data](https://www.algolia.com/doc/guides/search-analytics/guides/segments/).
  @JsonKey(name: r'analyticsTags')
  final List<String>? analyticsTags;

  /// Whether to include this search when calculating processing-time percentiles.
  @JsonKey(name: r'percentileComputation')
  final bool? percentileComputation;

  /// Whether to enable A/B testing for this search.
  @JsonKey(name: r'enableABTest')
  final bool? enableABTest;

  /// Attributes to include in the API response.  To reduce the size of your response, you can retrieve only some of the attributes. Attribute names are case-sensitive.  - `*` retrieves all attributes, except attributes included in the `customRanking` and `unretrievableAttributes` settings. - To retrieve all attributes except a specific one, prefix the attribute with a dash and combine it with the `*`: `[\"*\", \"-ATTRIBUTE\"]`. - The `objectID` attribute is always included.
  @JsonKey(name: r'attributesToRetrieve')
  final List<String>? attributesToRetrieve;

  /// Determines the order in which Algolia returns your results.  By default, each entry corresponds to a [ranking criteria](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/). The tie-breaking algorithm sequentially applies each criterion in the order they're specified. If you configure a replica index for [sorting by an attribute](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/how-to/sort-by-attribute/), you put the sorting attribute at the top of the list.  **Modifiers**  - `asc(\"ATTRIBUTE\")`.   Sort the index by the values of an attribute, in ascending order. - `desc(\"ATTRIBUTE\")`.   Sort the index by the values of an attribute, in descending order.  Before you modify the default setting, you should test your changes in the dashboard, and by [A/B testing](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/).
  @JsonKey(name: r'ranking')
  final List<String>? ranking;

  /// Attributes to use as [custom ranking](https://www.algolia.com/doc/guides/managing-results/must-do/custom-ranking/). Attribute names are case-sensitive.  The custom ranking attributes decide which items are shown first if the other ranking criteria are equal.  Records with missing values for your selected custom ranking attributes are always sorted last. Boolean attributes are sorted based on their alphabetical order.  **Modifiers**  - `asc(\"ATTRIBUTE\")`.   Sort the index by the values of an attribute, in ascending order.  - `desc(\"ATTRIBUTE\")`.   Sort the index by the values of an attribute, in descending order.  If you use two or more custom ranking attributes, [reduce the precision](https://www.algolia.com/doc/guides/managing-results/must-do/custom-ranking/how-to/controlling-custom-ranking-metrics-precision/) of your first attributes, or the other attributes will never be applied.
  @JsonKey(name: r'customRanking')
  final List<String>? customRanking;

  /// Relevancy threshold below which less relevant results aren't included in the results.  You can only set `relevancyStrictness` on [virtual replica indices](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/replicas/#what-are-virtual-replicas). Use this setting to strike a balance between the relevance and number of returned results.
  @JsonKey(name: r'relevancyStrictness')
  final int? relevancyStrictness;

  /// Attributes to highlight.  By default, all searchable attributes are highlighted. Use `*` to highlight all attributes or use an empty array `[]` to turn off highlighting. Attribute names are case-sensitive.  With highlighting, strings that match the search query are surrounded by HTML tags defined by `highlightPreTag` and `highlightPostTag`. You can use this to visually highlight matching parts of a search query in your UI.  For more information, see [Highlighting and snippeting](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/highlighting-snippeting/js/).
  @JsonKey(name: r'attributesToHighlight')
  final List<String>? attributesToHighlight;

  /// Attributes for which to enable snippets. Attribute names are case-sensitive.  Snippets provide additional context to matched words. If you enable snippets, they include 10 words, including the matched word. The matched word will also be wrapped by HTML tags for highlighting. You can adjust the number of words with the following notation: `ATTRIBUTE:NUMBER`, where `NUMBER` is the number of words to be extracted.
  @JsonKey(name: r'attributesToSnippet')
  final List<String>? attributesToSnippet;

  /// HTML tag to insert before the highlighted parts in all highlighted results and snippets.
  @JsonKey(name: r'highlightPreTag')
  final String? highlightPreTag;

  /// HTML tag to insert after the highlighted parts in all highlighted results and snippets.
  @JsonKey(name: r'highlightPostTag')
  final String? highlightPostTag;

  /// String used as an ellipsis indicator when a snippet is truncated.
  @JsonKey(name: r'snippetEllipsisText')
  final String? snippetEllipsisText;

  /// Whether to restrict highlighting and snippeting to items that at least partially matched the search query. By default, all items are highlighted and snippeted.
  @JsonKey(name: r'restrictHighlightAndSnippetArrays')
  final bool? restrictHighlightAndSnippetArrays;

  /// Number of hits per page.
  // minimum: 1
  // maximum: 1000
  @JsonKey(name: r'hitsPerPage')
  final int? hitsPerPage;

  /// Minimum number of characters a word in the search query must contain to accept matches with [one typo](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).
  @JsonKey(name: r'minWordSizefor1Typo')
  final int? minWordSizefor1Typo;

  /// Minimum number of characters a word in the search query must contain to accept matches with [two typos](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).
  @JsonKey(name: r'minWordSizefor2Typos')
  final int? minWordSizefor2Typos;

  /// One of types:
  /// - [TypoToleranceEnum]
  /// - [bool]
  @JsonKey(name: r'typoTolerance')
  final dynamic typoTolerance;

  /// Whether to allow typos on numbers in the search query.  Turn off this setting to reduce the number of irrelevant matches when searching in large sets of similar numbers.
  @JsonKey(name: r'allowTyposOnNumericTokens')
  final bool? allowTyposOnNumericTokens;

  /// Attributes for which you want to turn off [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/). Attribute names are case-sensitive.  Returning only exact matches can help when:  - [Searching in hyphenated attributes](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/how-to/how-to-search-in-hyphenated-attributes/). - Reducing the number of matches when you have too many.   This can happen with attributes that are long blocks of text, such as product descriptions.  Consider alternatives such as `disableTypoToleranceOnWords` or adding synonyms if your attributes have intentional unusual spellings that might look like typos.
  @JsonKey(name: r'disableTypoToleranceOnAttributes')
  final List<String>? disableTypoToleranceOnAttributes;

  /// One of types:
  /// - [BooleanString]
  /// - [bool]
  /// - [List<SupportedLanguage>]
  @JsonKey(name: r'ignorePlurals')
  final dynamic ignorePlurals;

  /// One of types:
  /// - [bool]
  /// - [List<SupportedLanguage>]
  @JsonKey(name: r'removeStopWords')
  final dynamic removeStopWords;

  /// Characters for which diacritics should be preserved.  By default, Algolia removes diacritics from letters. For example, `é` becomes `e`. If this causes issues in your search, you can specify characters that should keep their diacritics.
  @JsonKey(name: r'keepDiacriticsOnCharacters')
  final String? keepDiacriticsOnCharacters;

  /// Languages for language-specific query processing steps such as plurals, stop-word removal, and word-detection dictionaries.  This setting sets a default list of languages used by the `removeStopWords` and `ignorePlurals` settings. This setting also sets a dictionary for word detection in the logogram-based [CJK](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/#normalization-for-logogram-based-languages-cjk) languages. To support this, you must place the CJK language **first**.  **You should always specify a query language.** If you don't specify an indexing language, the search engine uses all [supported languages](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/), or the languages you specified with the `ignorePlurals` or `removeStopWords` parameters. This can lead to unexpected search results. For more information, see [Language-specific configuration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/).
  @JsonKey(name: r'queryLanguages')
  final List<SupportedLanguage>? queryLanguages;

  /// Whether to split compound words in the query into their building blocks.  For more information, see [Word segmentation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#splitting-compound-words). Word segmentation is supported for these languages: German, Dutch, Finnish, Swedish, and Norwegian. Decompounding doesn't work for words with [non-spacing mark Unicode characters](https://www.charactercodes.net/category/non-spacing_mark). For example, `Gartenstühle` won't be decompounded if the `ü` consists of `u` (U+0075) and `◌̈` (U+0308).
  @JsonKey(name: r'decompoundQuery')
  final bool? decompoundQuery;

  /// Whether to enable rules.
  @JsonKey(name: r'enableRules')
  final bool? enableRules;

  /// Whether to enable Personalization.
  @JsonKey(name: r'enablePersonalization')
  final bool? enablePersonalization;

  @JsonKey(name: r'queryType')
  final QueryType? queryType;

  @JsonKey(name: r'removeWordsIfNoResults')
  final RemoveWordsIfNoResults? removeWordsIfNoResults;

  @JsonKey(name: r'mode')
  final Mode? mode;

  @JsonKey(name: r'semanticSearch')
  final SemanticSearch? semanticSearch;

  /// Whether to support phrase matching and excluding words from search queries.  Use the `advancedSyntaxFeatures` parameter to control which feature is supported.
  @JsonKey(name: r'advancedSyntax')
  final bool? advancedSyntax;

  /// Words that should be considered optional when found in the query.  By default, records must match all words in the search query to be included in the search results. Adding optional words can help to increase the number of search results by running an additional search query that doesn't include the optional words. For example, if the search query is \"action video\" and \"video\" is an optional word, the search engine runs two queries. One for \"action video\" and one for \"action\". Records that match all words are ranked higher.  For a search query with 4 or more words **and** all its words are optional, the number of matched words required for a record to be included in the search results increases for every 1,000 records:  - If `optionalWords` has less than 10 words, the required number of matched words increases by 1:   results 1 to 1,000 require 1 matched word, results 1,001 to 2000 need 2 matched words. - If `optionalWords` has 10 or more words, the number of required matched words increases by the number of optional words divided by 5 (rounded down).   For example, with 18 optional words: results 1 to 1,000 require 1 matched word, results 1,001 to 2000 need 4 matched words.  For more information, see [Optional words](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/empty-or-insufficient-results/#creating-a-list-of-optional-words).
  @JsonKey(name: r'optionalWords')
  final List<String>? optionalWords;

  /// Searchable attributes for which you want to [turn off the Exact ranking criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes). Attribute names are case-sensitive.  This can be useful for attributes with long values, where the likelihood of an exact match is high, such as product descriptions. Turning off the Exact ranking criterion for these attributes favors exact matching on other attributes. This reduces the impact of individual attributes with a lot of content on ranking.
  @JsonKey(name: r'disableExactOnAttributes')
  final List<String>? disableExactOnAttributes;

  @JsonKey(name: r'exactOnSingleWordQuery')
  final ExactOnSingleWordQuery? exactOnSingleWordQuery;

  /// Alternatives of query words that should be considered as exact matches by the Exact ranking criterion.  - `ignorePlurals`.   Plurals and similar declensions added by the `ignorePlurals` setting are considered exact matches.  - `singleWordSynonym`.   Single-word synonyms, such as \"NY/NYC\" are considered exact matches.  - `multiWordsSynonym`.   Multi-word synonyms, such as \"NY/New York\" are considered exact matches.
  @JsonKey(name: r'alternativesAsExact')
  final List<AlternativesAsExact>? alternativesAsExact;

  /// Advanced search syntax features you want to support.  - `exactPhrase`.   Phrases in quotes must match exactly.   For example, `sparkly blue \"iPhone case\"` only returns records with the exact string \"iPhone case\".  - `excludeWords`.   Query words prefixed with a `-` must not occur in a record.   For example, `search -engine` matches records that contain \"search\" but not \"engine\".  This setting only has an effect if `advancedSyntax` is true.
  @JsonKey(name: r'advancedSyntaxFeatures')
  final List<AdvancedSyntaxFeatures>? advancedSyntaxFeatures;

  /// One of types:
  /// - [bool]
  /// - [int]
  @JsonKey(name: r'distinct')
  final dynamic distinct;

  /// Whether to replace a highlighted word with the matched synonym.  By default, the original words are highlighted even if a synonym matches. For example, with `home` as a synonym for `house` and a search for `home`, records matching either \"home\" or \"house\" are included in the search results, and either \"home\" or \"house\" are highlighted.  With `replaceSynonymsInHighlight` set to `true`, a search for `home` still matches the same records, but all occurrences of \"house\" are replaced by \"home\" in the highlighted response.
  @JsonKey(name: r'replaceSynonymsInHighlight')
  final bool? replaceSynonymsInHighlight;

  /// Minimum proximity score for two matching words.  This adjusts the [Proximity ranking criterion](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#proximity) by equally scoring matches that are farther apart.  For example, if `minProximity` is 2, neighboring matches and matches with one word between them would have the same score.
  // minimum: 1
  // maximum: 7
  @JsonKey(name: r'minProximity')
  final int? minProximity;

  /// Properties to include in the API response of `search` and `browse` requests.  By default, all response properties are included. To reduce the response size, you can select, which attributes should be included.  You can't exclude these properties: `message`, `warning`, `cursor`, `serverUsed`, `indexUsed`, `abTestVariantID`, `parsedQuery`, or any property triggered by the `getRankingInfo` parameter.  Don't exclude properties that you might need in your search UI.
  @JsonKey(name: r'responseFields')
  final List<String>? responseFields;

  /// Maximum number of facet values to return when [searching for facet values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values).
  // maximum: 100
  @JsonKey(name: r'maxFacetHits')
  final int? maxFacetHits;

  /// Maximum number of facet values to return for each facet.
  // maximum: 1000
  @JsonKey(name: r'maxValuesPerFacet')
  final int? maxValuesPerFacet;

  /// Order in which to retrieve facet values.  - `count`.   Facet values are retrieved by decreasing count.   The count is the number of matching records containing this facet value.  - `alpha`.   Retrieve facet values alphabetically.  This setting doesn't influence how facet values are displayed in your UI (see `renderingContent`). For more information, see [facet value display](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/facet-display/js/).
  @JsonKey(name: r'sortFacetValuesBy')
  final String? sortFacetValuesBy;

  /// Whether the best matching attribute should be determined by minimum proximity.  This setting only affects ranking if the Attribute ranking criterion comes before Proximity in the `ranking` setting. If true, the best matching attribute is selected based on the minimum proximity of multiple matches. Otherwise, the best matching attribute is determined by the order in the `searchableAttributes` setting.
  @JsonKey(name: r'attributeCriteriaComputedByMinProximity')
  final bool? attributeCriteriaComputedByMinProximity;

  @JsonKey(name: r'renderingContent')
  final RenderingContent? renderingContent;

  /// Whether this search will use [Dynamic Re-Ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/).  This setting only has an effect if you activated Dynamic Re-Ranking for this index in the Algolia dashboard.
  @JsonKey(name: r'enableReRanking')
  final bool? enableReRanking;

  /// One of types:
  /// - [List<List<ReRankingApplyFilter>>]
  /// - [String]
  /// - [List<String>]
  @JsonKey(name: r'reRankingApplyFilter')
  final dynamic reRankingApplyFilter;

  /// One of types:
  /// - [ConsequenceQueryObject]
  /// - [String]
  @JsonKey(name: r'query')
  final dynamic query;

  /// One of types:
  /// - [List<AutomaticFacetFilter>]
  /// - [List<String>]
  @JsonKey(name: r'automaticFacetFilters')
  final dynamic automaticFacetFilters;

  /// One of types:
  /// - [List<AutomaticFacetFilter>]
  /// - [List<String>]
  @JsonKey(name: r'automaticOptionalFacetFilters')
  final dynamic automaticOptionalFacetFilters;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is ConsequenceParams &&
          other.similarQuery == similarQuery &&
          other.filters == filters &&
          other.facetFilters == facetFilters &&
          other.optionalFilters == optionalFilters &&
          other.numericFilters == numericFilters &&
          other.tagFilters == tagFilters &&
          other.sumOrFiltersScores == sumOrFiltersScores &&
          other.restrictSearchableAttributes == restrictSearchableAttributes &&
          other.facets == facets &&
          other.facetingAfterDistinct == facetingAfterDistinct &&
          other.page == page &&
          other.offset == offset &&
          other.length == length &&
          other.aroundLatLng == aroundLatLng &&
          other.aroundLatLngViaIP == aroundLatLngViaIP &&
          other.aroundRadius == aroundRadius &&
          other.aroundPrecision == aroundPrecision &&
          other.minimumAroundRadius == minimumAroundRadius &&
          other.insideBoundingBox == insideBoundingBox &&
          other.insidePolygon == insidePolygon &&
          other.naturalLanguages == naturalLanguages &&
          other.ruleContexts == ruleContexts &&
          other.personalizationImpact == personalizationImpact &&
          other.userToken == userToken &&
          other.getRankingInfo == getRankingInfo &&
          other.synonyms == synonyms &&
          other.clickAnalytics == clickAnalytics &&
          other.analytics == analytics &&
          other.analyticsTags == analyticsTags &&
          other.percentileComputation == percentileComputation &&
          other.enableABTest == enableABTest &&
          other.attributesToRetrieve == attributesToRetrieve &&
          other.ranking == ranking &&
          other.customRanking == customRanking &&
          other.relevancyStrictness == relevancyStrictness &&
          other.attributesToHighlight == attributesToHighlight &&
          other.attributesToSnippet == attributesToSnippet &&
          other.highlightPreTag == highlightPreTag &&
          other.highlightPostTag == highlightPostTag &&
          other.snippetEllipsisText == snippetEllipsisText &&
          other.restrictHighlightAndSnippetArrays ==
              restrictHighlightAndSnippetArrays &&
          other.hitsPerPage == hitsPerPage &&
          other.minWordSizefor1Typo == minWordSizefor1Typo &&
          other.minWordSizefor2Typos == minWordSizefor2Typos &&
          other.typoTolerance == typoTolerance &&
          other.allowTyposOnNumericTokens == allowTyposOnNumericTokens &&
          other.disableTypoToleranceOnAttributes ==
              disableTypoToleranceOnAttributes &&
          other.ignorePlurals == ignorePlurals &&
          other.removeStopWords == removeStopWords &&
          other.keepDiacriticsOnCharacters == keepDiacriticsOnCharacters &&
          other.queryLanguages == queryLanguages &&
          other.decompoundQuery == decompoundQuery &&
          other.enableRules == enableRules &&
          other.enablePersonalization == enablePersonalization &&
          other.queryType == queryType &&
          other.removeWordsIfNoResults == removeWordsIfNoResults &&
          other.mode == mode &&
          other.semanticSearch == semanticSearch &&
          other.advancedSyntax == advancedSyntax &&
          other.optionalWords == optionalWords &&
          other.disableExactOnAttributes == disableExactOnAttributes &&
          other.exactOnSingleWordQuery == exactOnSingleWordQuery &&
          other.alternativesAsExact == alternativesAsExact &&
          other.advancedSyntaxFeatures == advancedSyntaxFeatures &&
          other.distinct == distinct &&
          other.replaceSynonymsInHighlight == replaceSynonymsInHighlight &&
          other.minProximity == minProximity &&
          other.responseFields == responseFields &&
          other.maxFacetHits == maxFacetHits &&
          other.maxValuesPerFacet == maxValuesPerFacet &&
          other.sortFacetValuesBy == sortFacetValuesBy &&
          other.attributeCriteriaComputedByMinProximity ==
              attributeCriteriaComputedByMinProximity &&
          other.renderingContent == renderingContent &&
          other.enableReRanking == enableReRanking &&
          other.reRankingApplyFilter == reRankingApplyFilter &&
          other.query == query &&
          other.automaticFacetFilters == automaticFacetFilters &&
          other.automaticOptionalFacetFilters == automaticOptionalFacetFilters;

  @override
  int get hashCode =>
      similarQuery.hashCode +
      filters.hashCode +
      facetFilters.hashCode +
      optionalFilters.hashCode +
      numericFilters.hashCode +
      tagFilters.hashCode +
      sumOrFiltersScores.hashCode +
      restrictSearchableAttributes.hashCode +
      facets.hashCode +
      facetingAfterDistinct.hashCode +
      page.hashCode +
      offset.hashCode +
      length.hashCode +
      aroundLatLng.hashCode +
      aroundLatLngViaIP.hashCode +
      aroundRadius.hashCode +
      aroundPrecision.hashCode +
      minimumAroundRadius.hashCode +
      insideBoundingBox.hashCode +
      insidePolygon.hashCode +
      naturalLanguages.hashCode +
      ruleContexts.hashCode +
      personalizationImpact.hashCode +
      userToken.hashCode +
      getRankingInfo.hashCode +
      synonyms.hashCode +
      clickAnalytics.hashCode +
      analytics.hashCode +
      analyticsTags.hashCode +
      percentileComputation.hashCode +
      enableABTest.hashCode +
      attributesToRetrieve.hashCode +
      ranking.hashCode +
      customRanking.hashCode +
      relevancyStrictness.hashCode +
      attributesToHighlight.hashCode +
      attributesToSnippet.hashCode +
      highlightPreTag.hashCode +
      highlightPostTag.hashCode +
      snippetEllipsisText.hashCode +
      restrictHighlightAndSnippetArrays.hashCode +
      hitsPerPage.hashCode +
      minWordSizefor1Typo.hashCode +
      minWordSizefor2Typos.hashCode +
      typoTolerance.hashCode +
      allowTyposOnNumericTokens.hashCode +
      disableTypoToleranceOnAttributes.hashCode +
      ignorePlurals.hashCode +
      removeStopWords.hashCode +
      keepDiacriticsOnCharacters.hashCode +
      queryLanguages.hashCode +
      decompoundQuery.hashCode +
      enableRules.hashCode +
      enablePersonalization.hashCode +
      queryType.hashCode +
      removeWordsIfNoResults.hashCode +
      mode.hashCode +
      semanticSearch.hashCode +
      advancedSyntax.hashCode +
      optionalWords.hashCode +
      disableExactOnAttributes.hashCode +
      exactOnSingleWordQuery.hashCode +
      alternativesAsExact.hashCode +
      advancedSyntaxFeatures.hashCode +
      distinct.hashCode +
      replaceSynonymsInHighlight.hashCode +
      minProximity.hashCode +
      responseFields.hashCode +
      maxFacetHits.hashCode +
      maxValuesPerFacet.hashCode +
      sortFacetValuesBy.hashCode +
      attributeCriteriaComputedByMinProximity.hashCode +
      renderingContent.hashCode +
      enableReRanking.hashCode +
      reRankingApplyFilter.hashCode +
      query.hashCode +
      automaticFacetFilters.hashCode +
      automaticOptionalFacetFilters.hashCode;

  factory ConsequenceParams.fromJson(Map<String, dynamic> json) =>
      _$ConsequenceParamsFromJson(json);

  Map<String, dynamic> toJson() => _$ConsequenceParamsToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
