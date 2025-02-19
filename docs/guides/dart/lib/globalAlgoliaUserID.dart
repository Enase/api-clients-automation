import 'package:algolia_client_search/algolia_client_search.dart';

void globalAlgoliaUserID() async {
  final client = SearchClient(
      appId: 'ALGOLIA_APPLICATION_ID',
      apiKey: 'ALGOLIA_API_KEY',
      options: ClientOptions(
        headers: {
          'X-Algolia-User-ID': 'test-user-123',
        },
      ));
  print(client.options.headers);
}
