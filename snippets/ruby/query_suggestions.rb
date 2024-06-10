# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
# >IMPORT
require 'algolia'
# IMPORT<

# Snippet for the createConfig method.
#
# createConfig
def snippet_for_create_config
  # >SEPARATOR createConfig default
  # Initialize the client
  client = Algolia::QuerySuggestionsClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  response = client.create_config(
    QuerySuggestionsConfigurationWithIndex.new(
      index_name: "theIndexName",
      source_indices: [SourceIndex.new(
        index_name: "testIndex",
        facets: [Facet.new(attribute: "test")],
        generate: [["facetA", "facetB"], ["facetC"]]
      )],
      languages: ["french"],
      exclude: ["test"]
    )
  )

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the customDelete method.
#
# allow del method for a custom path with minimal parameters
def snippet_for_custom_delete
  # >SEPARATOR customDelete default
  # Initialize the client
  client = Algolia::QuerySuggestionsClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  response = client.custom_delete("test/minimal")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the customGet method.
#
# allow get method for a custom path with minimal parameters
def snippet_for_custom_get
  # >SEPARATOR customGet default
  # Initialize the client
  client = Algolia::QuerySuggestionsClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  response = client.custom_get("test/minimal")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the customPost method.
#
# allow post method for a custom path with minimal parameters
def snippet_for_custom_post
  # >SEPARATOR customPost default
  # Initialize the client
  client = Algolia::QuerySuggestionsClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  response = client.custom_post("test/minimal")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the customPut method.
#
# allow put method for a custom path with minimal parameters
def snippet_for_custom_put
  # >SEPARATOR customPut default
  # Initialize the client
  client = Algolia::QuerySuggestionsClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  response = client.custom_put("test/minimal")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the deleteConfig method.
#
# deleteConfig
def snippet_for_delete_config
  # >SEPARATOR deleteConfig default
  # Initialize the client
  client = Algolia::QuerySuggestionsClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  response = client.delete_config("theIndexName")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the getAllConfigs method.
#
# getAllConfigs
def snippet_for_get_all_configs
  # >SEPARATOR getAllConfigs default
  # Initialize the client
  client = Algolia::QuerySuggestionsClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  response = client.get_all_configs

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the getConfig method.
#
# Retrieve QS config e2e
def snippet_for_get_config
  # >SEPARATOR getConfig default
  # Initialize the client
  client = Algolia::QuerySuggestionsClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  response = client.get_config("cts_e2e_browse_query_suggestions")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the getConfigStatus method.
#
# getConfigStatus
def snippet_for_get_config_status
  # >SEPARATOR getConfigStatus default
  # Initialize the client
  client = Algolia::QuerySuggestionsClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  response = client.get_config_status("theIndexName")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the getLogFile method.
#
# getLogFile
def snippet_for_get_log_file
  # >SEPARATOR getLogFile default
  # Initialize the client
  client = Algolia::QuerySuggestionsClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  response = client.get_log_file("theIndexName")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the updateConfig method.
#
# updateConfig
def snippet_for_update_config
  # >SEPARATOR updateConfig default
  # Initialize the client
  client = Algolia::QuerySuggestionsClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  response = client.update_config(
    "theIndexName",
    QuerySuggestionsConfiguration.new(
      source_indices: [SourceIndex.new(
        index_name: "testIndex",
        facets: [Facet.new(attribute: "test")],
        generate: [["facetA", "facetB"], ["facetC"]]
      )],
      languages: ["french"],
      exclude: ["test"]
    )
  )

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end
