// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
/* eslint-disable @typescript-eslint/no-unused-vars, require-await, no-lone-blocks */
// @ts-nocheck Failing tests will have type errors, but we cannot suppress them even with @ts-expect-error because it doesn't work for a block of lines.
import type { QuerySuggestionsClient } from '@algolia/client-query-suggestions';
import { querySuggestionsClient } from '@algolia/client-query-suggestions';
import { echoRequester } from '@algolia/requester-node-http';
import type { EchoResponse } from '@algolia/requester-node-http';

const appId = 'test-app-id';
const apiKey = 'test-api-key';

function createClient(): QuerySuggestionsClient {
  return querySuggestionsClient(appId, apiKey, 'us', { requester: echoRequester() });
}

describe('commonApi', () => {
  test('calls api with correct user agent', async () => {
    const client = createClient();

    const result = (await client.customPost({ path: '1/test' })) as unknown as EchoResponse;

    expect(decodeURIComponent(result.algoliaAgent)).toMatch(
      /^Algolia for JavaScript \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; QuerySuggestions (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$/,
    );
  }, 15000);

  test('the user agent contains the latest version', async () => {
    const client = createClient();

    const result = (await client.customPost({ path: '1/test' })) as unknown as EchoResponse;

    expect(decodeURIComponent(result.algoliaAgent)).toMatch(/^Algolia for JavaScript \(5.2.5\).*/);
  }, 15000);

  test('calls api with default read timeouts', async () => {
    const client = createClient();

    const result = (await client.customGet({ path: '1/test' })) as unknown as EchoResponse;

    expect(result).toEqual(expect.objectContaining({ connectTimeout: 2000, responseTimeout: 5000 }));
  }, 15000);

  test('calls api with default write timeouts', async () => {
    const client = createClient();

    const result = (await client.customPost({ path: '1/test' })) as unknown as EchoResponse;

    expect(result).toEqual(expect.objectContaining({ connectTimeout: 2000, responseTimeout: 30000 }));
  }, 15000);
});

describe('parameters', () => {
  test('throws when region is not given', async () => {
    try {
      const client = querySuggestionsClient('my-app-id', 'my-api-key', '', { requester: echoRequester() });
      throw new Error('test is expected to throw error');
    } catch (e) {
      expect((e as Error).message).toMatch('`region` is required and must be one of the following: eu, us');
    }
  }, 15000);

  test('throws when incorrect region is given', async () => {
    try {
      const client = querySuggestionsClient('my-app-id', 'my-api-key', 'not_a_region', { requester: echoRequester() });
      throw new Error('test is expected to throw error');
    } catch (e) {
      expect((e as Error).message).toMatch('`region` is required and must be one of the following: eu, us');
    }
  }, 15000);

  test('does not throw when region is given', async () => {
    const client = querySuggestionsClient('my-app-id', 'my-api-key', 'us', { requester: echoRequester() });
  }, 15000);
});

describe('setClientApiKey', () => {
  test('switch API key', async () => {
    const client = querySuggestionsClient('test-app-id', 'test-api-key', 'us', {
      hosts: [{ url: 'localhost', port: 6683, accept: 'readWrite', protocol: 'http' }],
    });

    {
      const result = await client.customGet({ path: 'check-api-key/1' });

      expect(result).toEqual({ headerAPIKeyValue: 'test-api-key' });
    }
    {
      client.setClientApiKey({ apiKey: 'updated-api-key' });
    }
    {
      const result = await client.customGet({ path: 'check-api-key/2' });

      expect(result).toEqual({ headerAPIKeyValue: 'updated-api-key' });
    }
  }, 15000);
});

describe('init', () => {
  test('sets authMode', async () => {
    const qpClient = querySuggestionsClient('foo', 'bar', 'us', {
      authMode: 'WithinQueryParameters',
      requester: echoRequester(),
    });
    const headerClient = querySuggestionsClient('foo', 'bar', 'us', {
      authMode: 'WithinHeaders',
      requester: echoRequester(),
    });

    const qpResult = (await qpClient.customGet({
      path: '1/foo',
    })) as unknown as EchoResponse;
    expect(qpResult.searchParams).toEqual({
      'x-algolia-api-key': 'bar',
      'x-algolia-application-id': 'foo',
    });

    const headerResult = (await headerClient.customGet({
      path: '1/bar',
    })) as unknown as EchoResponse;
    expect(headerResult.headers).toEqual({
      accept: 'application/json',
      'content-type': 'text/plain',
      'x-algolia-api-key': 'bar',
      'x-algolia-application-id': 'foo',
    });
  });
});
