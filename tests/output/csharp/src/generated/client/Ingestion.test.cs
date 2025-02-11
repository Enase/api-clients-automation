// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
using System.Text.Json;
using System.Text.RegularExpressions;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Common;
using Algolia.Search.Models.Ingestion;
using Algolia.Search.Serializer;
using Algolia.Search.Tests.Utils;
using Algolia.Search.Transport;
using Quibble.Xunit;
using Xunit;

namespace Algolia.Search.client;

public class IngestionClientTests
{
  private readonly EchoHttpRequester _echo;
  private Exception _ex;

  public IngestionClientTests()
  {
    _echo = new EchoHttpRequester();
  }

  [Fact]
  public void Dispose() { }

  [Fact(DisplayName = "can handle HTML error")]
  public async Task ApiTest0()
  {
    IngestionConfig _config = new IngestionConfig("test-app-id", "test-api-key", "us")
    {
      CustomHosts = new List<StatefulHost>
      {
        new()
        {
          Scheme = HttpScheme.Http,
          Url =
            Environment.GetEnvironmentVariable("CI") == "true"
              ? "localhost"
              : "host.docker.internal",
          Port = 6676,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
      },
    };
    var client = new IngestionClient(_config);

    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var res = await client.CustomGetAsync("1/html-error");
    });
    Assert.Equal(
      "<html><body>429 too many requests</body></html>".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );
  }

  [Fact(DisplayName = "calls api with default read timeouts")]
  public async Task ApiTest1()
  {
    var client = new IngestionClient(new IngestionConfig("appId", "apiKey", "us"), _echo);
    await client.CustomGetAsync("1/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal(25000, result.ConnectTimeout.TotalMilliseconds);
    Assert.Equal(25000, result.ResponseTimeout.TotalMilliseconds);
  }

  [Fact(DisplayName = "calls api with default write timeouts")]
  public async Task ApiTest2()
  {
    var client = new IngestionClient(new IngestionConfig("appId", "apiKey", "us"), _echo);
    await client.CustomPostAsync("1/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal(25000, result.ConnectTimeout.TotalMilliseconds);
    Assert.Equal(25000, result.ResponseTimeout.TotalMilliseconds);
  }

  [Fact(DisplayName = "endpoint level timeout")]
  public async Task ApiTest3()
  {
    var client = new IngestionClient(new IngestionConfig("appId", "apiKey", "us"), _echo);
    await client.ValidateSourceBeforeUpdateAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new SourceUpdate { Name = "newName" }
    );
    EchoResponse result = _echo.LastResponse;

    Assert.Equal(180000, result.ConnectTimeout.TotalMilliseconds);
    Assert.Equal(180000, result.ResponseTimeout.TotalMilliseconds);
  }

  [Fact(DisplayName = "can override endpoint level timeout")]
  public async Task ApiTest4()
  {
    var client = new IngestionClient(new IngestionConfig("appId", "apiKey", "us"), _echo);
    await client.ValidateSourceBeforeUpdateAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new SourceUpdate { Name = "newName" },
      new RequestOptionBuilder().SetWriteTimeout(TimeSpan.FromMilliseconds(3456)).Build()
    );
    EchoResponse result = _echo.LastResponse;

    Assert.Equal(180000, result.ConnectTimeout.TotalMilliseconds);
    Assert.Equal(3456, result.ResponseTimeout.TotalMilliseconds);
  }

  [Fact(DisplayName = "calls api with correct user agent")]
  public async Task CommonApiTest0()
  {
    var client = new IngestionClient(new IngestionConfig("appId", "apiKey", "us"), _echo);
    await client.CustomPostAsync("1/test");
    EchoResponse result = _echo.LastResponse;
    {
      var regexp = new Regex(
        "^Algolia for Csharp \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Ingestion (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
      );
      Assert.Matches(regexp, result.Headers["user-agent"]);
    }
  }

  [Fact(DisplayName = "the user agent contains the latest version")]
  public async Task CommonApiTest1()
  {
    var client = new IngestionClient(new IngestionConfig("appId", "apiKey", "us"), _echo);
    await client.CustomPostAsync("1/test");
    EchoResponse result = _echo.LastResponse;
    {
      var regexp = new Regex("^Algolia for Csharp \\(7.13.2\\).*");
      Assert.Matches(regexp, result.Headers["user-agent"]);
    }
  }

  [Fact(DisplayName = "uses the correct region")]
  public async Task ParametersTest0()
  {
    var client = new IngestionClient(new IngestionConfig("my-app-id", "my-api-key", "us"), _echo);

    await client.GetSourceAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal("data.us.algolia.com", result.Host);
  }

  [Fact(DisplayName = "throws when incorrect region is given")]
  public async Task ParametersTest1()
  {
    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var client = new IngestionClient(
        new IngestionConfig("my-app-id", "my-api-key", "not_a_region"),
        _echo
      );
    });
    Assert.Equal(
      "`region` is required and must be one of the following: eu, us".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );
  }

  [Fact(DisplayName = "switch API key")]
  public async Task SetClientApiKeyTest0()
  {
    IngestionConfig _config = new IngestionConfig("test-app-id", "test-api-key", "us")
    {
      CustomHosts = new List<StatefulHost>
      {
        new()
        {
          Scheme = HttpScheme.Http,
          Url =
            Environment.GetEnvironmentVariable("CI") == "true"
              ? "localhost"
              : "host.docker.internal",
          Port = 6683,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
      },
    };
    var client = new IngestionClient(_config);

    {
      var res = await client.CustomGetAsync("check-api-key/1");

      JsonAssert.EqualOverrideDefault(
        "{\"headerAPIKeyValue\":\"test-api-key\"}",
        JsonSerializer.Serialize(res, JsonConfig.Options),
        new JsonDiffConfig(false)
      );
    }
    {
      client.SetClientApiKey("updated-api-key");
    }
    {
      var res = await client.CustomGetAsync("check-api-key/2");

      JsonAssert.EqualOverrideDefault(
        "{\"headerAPIKeyValue\":\"updated-api-key\"}",
        JsonSerializer.Serialize(res, JsonConfig.Options),
        new JsonDiffConfig(false)
      );
    }
  }
}
