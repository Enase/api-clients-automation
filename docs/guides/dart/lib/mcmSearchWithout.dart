import 'package:algolia_client_search/algolia_client_search.dart';

String getAppIDFor(String _) {
  return ""; // Implement your own logic here
}

String getIndexingApiKeyFor(String _) {
  return ""; // Implement your own logic here
}

void mcmSearchWithout() async {
  // Fetch from your own data storage and with your own code
  // the associated application ID and API key for this user
  final appId = getAppIDFor("user42");
  final apiKey = getIndexingApiKeyFor("user42");

  final client = SearchClient(appId: appId, apiKey: apiKey);
  final searchParams = SearchParamsObject(
      query: "<YOUR_SEARCH_QUERY>",
      facetFilters: ["user:user42", "user:public"]);

  await client.searchSingleIndex(
    indexName: "<YOUR_INDEX_NAME>",
    searchParams: searchParams,
  );
}
