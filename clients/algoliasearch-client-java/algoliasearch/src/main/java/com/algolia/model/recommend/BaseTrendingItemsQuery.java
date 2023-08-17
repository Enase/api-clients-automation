// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.recommend;

import com.fasterxml.jackson.annotation.*;
import java.util.Objects;

/** BaseTrendingItemsQuery */
public class BaseTrendingItemsQuery {

  @JsonProperty("facetName")
  private String facetName;

  @JsonProperty("facetValue")
  private String facetValue;

  @JsonProperty("model")
  private TrendingItemsModel model;

  @JsonProperty("queryParameters")
  private SearchParamsObject queryParameters;

  @JsonProperty("fallbackParameters")
  private SearchParamsObject fallbackParameters;

  public BaseTrendingItemsQuery setFacetName(String facetName) {
    this.facetName = facetName;
    return this;
  }

  /**
   * Facet name for trending models.
   *
   * @return facetName
   */
  @javax.annotation.Nullable
  public String getFacetName() {
    return facetName;
  }

  public BaseTrendingItemsQuery setFacetValue(String facetValue) {
    this.facetValue = facetValue;
    return this;
  }

  /**
   * Facet value for trending models.
   *
   * @return facetValue
   */
  @javax.annotation.Nullable
  public String getFacetValue() {
    return facetValue;
  }

  public BaseTrendingItemsQuery setModel(TrendingItemsModel model) {
    this.model = model;
    return this;
  }

  /**
   * Get model
   *
   * @return model
   */
  @javax.annotation.Nullable
  public TrendingItemsModel getModel() {
    return model;
  }

  public BaseTrendingItemsQuery setQueryParameters(SearchParamsObject queryParameters) {
    this.queryParameters = queryParameters;
    return this;
  }

  /**
   * Get queryParameters
   *
   * @return queryParameters
   */
  @javax.annotation.Nullable
  public SearchParamsObject getQueryParameters() {
    return queryParameters;
  }

  public BaseTrendingItemsQuery setFallbackParameters(SearchParamsObject fallbackParameters) {
    this.fallbackParameters = fallbackParameters;
    return this;
  }

  /**
   * Get fallbackParameters
   *
   * @return fallbackParameters
   */
  @javax.annotation.Nullable
  public SearchParamsObject getFallbackParameters() {
    return fallbackParameters;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseTrendingItemsQuery baseTrendingItemsQuery = (BaseTrendingItemsQuery) o;
    return (
      Objects.equals(this.facetName, baseTrendingItemsQuery.facetName) &&
      Objects.equals(this.facetValue, baseTrendingItemsQuery.facetValue) &&
      Objects.equals(this.model, baseTrendingItemsQuery.model) &&
      Objects.equals(this.queryParameters, baseTrendingItemsQuery.queryParameters) &&
      Objects.equals(this.fallbackParameters, baseTrendingItemsQuery.fallbackParameters)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(facetName, facetValue, model, queryParameters, fallbackParameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BaseTrendingItemsQuery {\n");
    sb.append("    facetName: ").append(toIndentedString(facetName)).append("\n");
    sb.append("    facetValue: ").append(toIndentedString(facetValue)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    queryParameters: ").append(toIndentedString(queryParameters)).append("\n");
    sb.append("    fallbackParameters: ").append(toIndentedString(fallbackParameters)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
