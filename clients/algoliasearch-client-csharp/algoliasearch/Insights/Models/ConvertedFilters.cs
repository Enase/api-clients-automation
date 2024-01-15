//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//

using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.IO;
using System.Runtime.Serialization;
using System.Text;
using System.Text.RegularExpressions;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;
using Newtonsoft.Json.Linq;
using Algolia.Search.Models;

namespace Algolia.Search.Models.Insights
{
  /// <summary>
  /// ConvertedFilters
  /// </summary>
  [DataContract(Name = "ConvertedFilters")]
  public partial class ConvertedFilters
  {

    /// <summary>
    /// Gets or Sets EventType
    /// </summary>
    [DataMember(Name = "eventType", IsRequired = true, EmitDefaultValue = true)]
    public ConversionEvent EventType { get; set; }
    /// <summary>
    /// Initializes a new instance of the <see cref="ConvertedFilters" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public ConvertedFilters() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="ConvertedFilters" /> class.
    /// </summary>
    /// <param name="eventName">The name of the event, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment&#39;s [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework.  (required).</param>
    /// <param name="eventType">eventType (required).</param>
    /// <param name="index">The name of an Algolia index. (required).</param>
    /// <param name="filters">Facet filters.  Each facet filter string must be URL-encoded, such as, &#x60;discount:10%25&#x60;.  (required).</param>
    /// <param name="userToken">An anonymous or pseudonymous user identifier.  &gt; **Note**: Never include personally identifiable information in user tokens.  (required).</param>
    public ConvertedFilters(string eventName, ConversionEvent eventType, string index, List<string> filters, string userToken)
    {
      this.EventName = eventName ?? throw new ArgumentNullException("eventName is a required property for ConvertedFilters and cannot be null");
      this.EventType = eventType;
      this.Index = index ?? throw new ArgumentNullException("index is a required property for ConvertedFilters and cannot be null");
      this.Filters = filters ?? throw new ArgumentNullException("filters is a required property for ConvertedFilters and cannot be null");
      this.UserToken = userToken ?? throw new ArgumentNullException("userToken is a required property for ConvertedFilters and cannot be null");
    }

    /// <summary>
    /// The name of the event, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment&#39;s [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework. 
    /// </summary>
    /// <value>The name of the event, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment&#39;s [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework. </value>
    [DataMember(Name = "eventName", IsRequired = true, EmitDefaultValue = true)]
    public string EventName { get; set; }

    /// <summary>
    /// The name of an Algolia index.
    /// </summary>
    /// <value>The name of an Algolia index.</value>
    [DataMember(Name = "index", IsRequired = true, EmitDefaultValue = true)]
    public string Index { get; set; }

    /// <summary>
    /// Facet filters.  Each facet filter string must be URL-encoded, such as, &#x60;discount:10%25&#x60;. 
    /// </summary>
    /// <value>Facet filters.  Each facet filter string must be URL-encoded, such as, &#x60;discount:10%25&#x60;. </value>
    [DataMember(Name = "filters", IsRequired = true, EmitDefaultValue = true)]
    public List<string> Filters { get; set; }

    /// <summary>
    /// An anonymous or pseudonymous user identifier.  &gt; **Note**: Never include personally identifiable information in user tokens. 
    /// </summary>
    /// <value>An anonymous or pseudonymous user identifier.  &gt; **Note**: Never include personally identifiable information in user tokens. </value>
    [DataMember(Name = "userToken", IsRequired = true, EmitDefaultValue = true)]
    public string UserToken { get; set; }

    /// <summary>
    /// An identifier for authenticated users.  &gt; **Note**: Never include personally identifiable information in user tokens. 
    /// </summary>
    /// <value>An identifier for authenticated users.  &gt; **Note**: Never include personally identifiable information in user tokens. </value>
    [DataMember(Name = "authenticatedUserToken", EmitDefaultValue = false)]
    public string AuthenticatedUserToken { get; set; }

    /// <summary>
    /// The timestamp of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp. 
    /// </summary>
    /// <value>The timestamp of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp. </value>
    [DataMember(Name = "timestamp", EmitDefaultValue = false)]
    public long Timestamp { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class ConvertedFilters {\n");
      sb.Append("  EventName: ").Append(EventName).Append("\n");
      sb.Append("  EventType: ").Append(EventType).Append("\n");
      sb.Append("  Index: ").Append(Index).Append("\n");
      sb.Append("  Filters: ").Append(Filters).Append("\n");
      sb.Append("  UserToken: ").Append(UserToken).Append("\n");
      sb.Append("  AuthenticatedUserToken: ").Append(AuthenticatedUserToken).Append("\n");
      sb.Append("  Timestamp: ").Append(Timestamp).Append("\n");
      sb.Append("}\n");
      return sb.ToString();
    }

    /// <summary>
    /// Returns the JSON string presentation of the object
    /// </summary>
    /// <returns>JSON string presentation of the object</returns>
    public virtual string ToJson()
    {
      return Newtonsoft.Json.JsonConvert.SerializeObject(this, Newtonsoft.Json.Formatting.Indented);
    }

  }

}
