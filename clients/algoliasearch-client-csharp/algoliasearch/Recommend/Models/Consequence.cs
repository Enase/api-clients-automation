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

namespace Algolia.Search.Models.Recommend
{
  /// <summary>
  /// [Consequences](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/#consequences) of a rule. 
  /// </summary>
  [DataContract(Name = "consequence")]
  public partial class Consequence
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="Consequence" /> class.
    /// </summary>
    public Consequence()
    {
    }

    /// <summary>
    /// Gets or Sets VarParams
    /// </summary>
    [DataMember(Name = "params", EmitDefaultValue = false)]
    public ConsequenceParams VarParams { get; set; }

    /// <summary>
    /// Records to promote.
    /// </summary>
    /// <value>Records to promote.</value>
    [DataMember(Name = "promote", EmitDefaultValue = false)]
    public List<Promote> Promote { get; set; }

    /// <summary>
    /// Only use in combination with the &#x60;promote&#x60; consequence. When &#x60;true&#x60;, promoted results will be restricted to match the filters of the current search. When &#x60;false&#x60;, the promoted results will show up regardless of the filters.
    /// </summary>
    /// <value>Only use in combination with the &#x60;promote&#x60; consequence. When &#x60;true&#x60;, promoted results will be restricted to match the filters of the current search. When &#x60;false&#x60;, the promoted results will show up regardless of the filters.</value>
    [DataMember(Name = "filterPromotes", EmitDefaultValue = false)]
    public bool? FilterPromotes { get; set; }

    /// <summary>
    /// Records to hide. By default, you can hide up to 50 records per rule.
    /// </summary>
    /// <value>Records to hide. By default, you can hide up to 50 records per rule.</value>
    [DataMember(Name = "hide", EmitDefaultValue = false)]
    public List<ConsequenceHide> Hide { get; set; }

    /// <summary>
    /// Custom JSON object that will be appended to the userData array in the response. This object isn&#39;t interpreted by the API. It&#39;s limited to 1kB of minified JSON.
    /// </summary>
    /// <value>Custom JSON object that will be appended to the userData array in the response. This object isn&#39;t interpreted by the API. It&#39;s limited to 1kB of minified JSON.</value>
    [DataMember(Name = "userData", EmitDefaultValue = false)]
    public Object UserData { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class Consequence {\n");
      sb.Append("  VarParams: ").Append(VarParams).Append("\n");
      sb.Append("  Promote: ").Append(Promote).Append("\n");
      sb.Append("  FilterPromotes: ").Append(FilterPromotes).Append("\n");
      sb.Append("  Hide: ").Append(Hide).Append("\n");
      sb.Append("  UserData: ").Append(UserData).Append("\n");
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
