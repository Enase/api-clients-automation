# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
# >IMPORT
from algoliasearch.usage.client import UsageClient

# IMPORT<


async def snippet_for_custom_delete():
    """
    Snippet for the customDelete method.

    allow del method for a custom path with minimal parameters
    """
    # >SEPARATOR customDelete default
    # Initialize the client
    _client = UsageClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    response = await _client.custom_delete(
        path="test/minimal",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_custom_get():
    """
    Snippet for the customGet method.

    allow get method for a custom path with minimal parameters
    """
    # >SEPARATOR customGet default
    # Initialize the client
    _client = UsageClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    response = await _client.custom_get(
        path="test/minimal",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_custom_post():
    """
    Snippet for the customPost method.

    allow post method for a custom path with minimal parameters
    """
    # >SEPARATOR customPost default
    # Initialize the client
    _client = UsageClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    response = await _client.custom_post(
        path="test/minimal",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_custom_put():
    """
    Snippet for the customPut method.

    allow put method for a custom path with minimal parameters
    """
    # >SEPARATOR customPut default
    # Initialize the client
    _client = UsageClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    response = await _client.custom_put(
        path="test/minimal",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_get_index_usage():
    """
    Snippet for the getIndexUsage method.

    getIndexUsage with minimal parameters
    """
    # >SEPARATOR getIndexUsage default
    # Initialize the client
    _client = UsageClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    response = await _client.get_index_usage(
        statistic="queries_operations",
        index_name="myIndexName",
        start_date="2024-04-03T12:46:43Z",
        end_date="2024-04-05T12:46:43Z",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_get_usage():
    """
    Snippet for the getUsage method.

    getUsage with minimal parameters
    """
    # >SEPARATOR getUsage default
    # Initialize the client
    _client = UsageClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    response = await _client.get_usage(
        statistic="queries_operations",
        start_date="2024-04-03T12:46:43Z",
        end_date="2024-04-05T12:46:43Z",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<
