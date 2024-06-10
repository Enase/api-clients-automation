package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.IngestionClient;
import com.algolia.model.ingestion.*;

// IMPORT<

class SnippetIngestionClient {

  // Snippet for the createAuthentication method.
  //
  // createAuthenticationOAuth
  void snippetForCreateAuthentication() {
    // >SEPARATOR createAuthentication default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.createAuthentication(
      new AuthenticationCreate()
        .setType(AuthenticationType.fromValue("oauth"))
        .setName("authName")
        .setInput(new AuthOAuth().setUrl("http://test.oauth").setClientId("myID").setClientSecret("mySecret"))
    );
    // SEPARATOR<
  }

  // Snippet for the createDestination method.
  //
  // createDestination
  void snippetForCreateDestination() {
    // >SEPARATOR createDestination default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.createDestination(
      new DestinationCreate()
        .setType(DestinationType.fromValue("search"))
        .setName("destinationName")
        .setInput(new DestinationIndexPrefix().setIndexPrefix("prefix_"))
        .setAuthenticationID("6c02aeb1-775e-418e-870b-1faccd4b2c0f")
    );
    // SEPARATOR<
  }

  // Snippet for the createSource method.
  //
  // createSource
  void snippetForCreateSource() {
    // >SEPARATOR createSource default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.createSource(
      new SourceCreate()
        .setType(SourceType.fromValue("commercetools"))
        .setName("sourceName")
        .setInput(
          new SourceCommercetools()
            .setStoreKeys(List.of("myStore"))
            .setLocales(List.of("de"))
            .setUrl("http://commercetools.com")
            .setProjectKey("keyID")
        )
        .setAuthenticationID("6c02aeb1-775e-418e-870b-1faccd4b2c0f")
    );
    // SEPARATOR<
  }

  // Snippet for the createTask method.
  //
  // createTaskOnDemand
  void snippetForCreateTask() {
    // >SEPARATOR createTask default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.createTask(
      new TaskCreate()
        .setSourceID("search")
        .setDestinationID("destinationName")
        .setTrigger(new OnDemandTriggerInput().setType(OnDemandTriggerType.fromValue("onDemand")))
        .setAction(ActionType.fromValue("replace"))
    );
    // SEPARATOR<
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // >SEPARATOR customDelete default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customDelete("test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() {
    // >SEPARATOR customGet default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customGet("test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() {
    // >SEPARATOR customPost default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customPost("test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() {
    // >SEPARATOR customPut default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customPut("test/minimal");
    // SEPARATOR<
  }

  // Snippet for the deleteAuthentication method.
  //
  // deleteAuthentication
  void snippetForDeleteAuthentication() {
    // >SEPARATOR deleteAuthentication default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.deleteAuthentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  // Snippet for the deleteDestination method.
  //
  // deleteDestination
  void snippetForDeleteDestination() {
    // >SEPARATOR deleteDestination default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.deleteDestination("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  // Snippet for the deleteSource method.
  //
  // deleteSource
  void snippetForDeleteSource() {
    // >SEPARATOR deleteSource default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.deleteSource("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  // Snippet for the deleteTask method.
  //
  // deleteTask
  void snippetForDeleteTask() {
    // >SEPARATOR deleteTask default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.deleteTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  // Snippet for the disableTask method.
  //
  // disableTask
  void snippetForDisableTask() {
    // >SEPARATOR disableTask default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.disableTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  // Snippet for the enableTask method.
  //
  // enable task e2e
  void snippetForEnableTask() {
    // >SEPARATOR enableTask default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.enableTask("76ab4c2a-ce17-496f-b7a6-506dc59ee498");
    // SEPARATOR<
  }

  // Snippet for the getAuthentication method.
  //
  // getAuthentication
  void snippetForGetAuthentication() {
    // >SEPARATOR getAuthentication default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getAuthentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  // Snippet for the getAuthentications method.
  //
  // getAuthentications
  void snippetForGetAuthentications() {
    // >SEPARATOR getAuthentications default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getAuthentications();
    // SEPARATOR<
  }

  // Snippet for the getDestination method.
  //
  // getDestination
  void snippetForGetDestination() {
    // >SEPARATOR getDestination default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getDestination("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  // Snippet for the getDestinations method.
  //
  // getDestinations
  void snippetForGetDestinations() {
    // >SEPARATOR getDestinations default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getDestinations();
    // SEPARATOR<
  }

  // Snippet for the getDockerSourceStreams method.
  //
  // getDockerSourceStreams
  void snippetForGetDockerSourceStreams() {
    // >SEPARATOR getDockerSourceStreams default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getDockerSourceStreams("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  // Snippet for the getEvent method.
  //
  // getEvent
  void snippetForGetEvent() {
    // >SEPARATOR getEvent default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getEvent("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "6c02aeb1-775e-418e-870b-1faccd4b2c0c");
    // SEPARATOR<
  }

  // Snippet for the getEvents method.
  //
  // getEvents
  void snippetForGetEvents() {
    // >SEPARATOR getEvents default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getEvents("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  // Snippet for the getRun method.
  //
  // getRun
  void snippetForGetRun() {
    // >SEPARATOR getRun default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getRun("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  // Snippet for the getRuns method.
  //
  // getRuns
  void snippetForGetRuns() {
    // >SEPARATOR getRuns default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getRuns();
    // SEPARATOR<
  }

  // Snippet for the getSource method.
  //
  // getSource
  void snippetForGetSource() {
    // >SEPARATOR getSource default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getSource("75eeb306-51d3-4e5e-a279-3c92bd8893ac");
    // SEPARATOR<
  }

  // Snippet for the getSources method.
  //
  // getSources
  void snippetForGetSources() {
    // >SEPARATOR getSources default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getSources();
    // SEPARATOR<
  }

  // Snippet for the getTask method.
  //
  // getTask
  void snippetForGetTask() {
    // >SEPARATOR getTask default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  // Snippet for the getTasks method.
  //
  // getTasks
  void snippetForGetTasks() {
    // >SEPARATOR getTasks default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getTasks();
    // SEPARATOR<
  }

  // Snippet for the runTask method.
  //
  // runTask
  void snippetForRunTask() {
    // >SEPARATOR runTask default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.runTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  // Snippet for the searchAuthentications method.
  //
  // searchAuthentications
  void snippetForSearchAuthentications() {
    // >SEPARATOR searchAuthentications default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.searchAuthentications(
      new AuthenticationSearch()
        .setAuthenticationIDs(List.of("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"))
    );
    // SEPARATOR<
  }

  // Snippet for the searchDestinations method.
  //
  // searchDestinations
  void snippetForSearchDestinations() {
    // >SEPARATOR searchDestinations default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.searchDestinations(
      new DestinationSearch().setDestinationIDs(List.of("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"))
    );
    // SEPARATOR<
  }

  // Snippet for the searchSources method.
  //
  // searchSources
  void snippetForSearchSources() {
    // >SEPARATOR searchSources default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.searchSources(
      new SourceSearch().setSourceIDs(List.of("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"))
    );
    // SEPARATOR<
  }

  // Snippet for the searchTasks method.
  //
  // searchTasks
  void snippetForSearchTasks() {
    // >SEPARATOR searchTasks default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.searchTasks(
      new TaskSearch()
        .setTaskIDs(
          List.of("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a", "76ab4c2a-ce17-496f-b7a6-506dc59ee498")
        )
    );
    // SEPARATOR<
  }

  // Snippet for the triggerDockerSourceDiscover method.
  //
  // triggerDockerSourceDiscover
  void snippetForTriggerDockerSourceDiscover() {
    // >SEPARATOR triggerDockerSourceDiscover default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.triggerDockerSourceDiscover("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  // Snippet for the updateAuthentication method.
  //
  // updateAuthentication
  void snippetForUpdateAuthentication() {
    // >SEPARATOR updateAuthentication default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.updateAuthentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new AuthenticationUpdate().setName("newName"));
    // SEPARATOR<
  }

  // Snippet for the updateDestination method.
  //
  // updateDestination
  void snippetForUpdateDestination() {
    // >SEPARATOR updateDestination default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.updateDestination("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new DestinationUpdate().setName("newName"));
    // SEPARATOR<
  }

  // Snippet for the updateSource method.
  //
  // updateSource
  void snippetForUpdateSource() {
    // >SEPARATOR updateSource default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.updateSource("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new SourceUpdate().setName("newName"));
    // SEPARATOR<
  }

  // Snippet for the updateTask method.
  //
  // updateTask
  void snippetForUpdateTask() {
    // >SEPARATOR updateTask default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.updateTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new TaskUpdate().setEnabled(false));
    // SEPARATOR<
  }
}
