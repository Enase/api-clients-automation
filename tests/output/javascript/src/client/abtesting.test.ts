// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
/* eslint-disable @typescript-eslint/no-unused-vars, require-await */
// @ts-nocheck Failing tests will have type errors, but we cannot suppress them even with @ts-expect-error because it doesn't work for a block of lines.
import type { AbtestingClient } from '@algolia/client-abtesting';
import { abtestingClient } from '@algolia/client-abtesting';
import { echoRequester } from '@algolia/requester-node-http';
import type { EchoResponse } from '@algolia/requester-node-http';

const appId = 'test-app-id';
const apiKey = 'test-api-key';

function createClient(): AbtestingClient {
  return abtestingClient(appId, apiKey, 'us', { requester: echoRequester() });
}

describe('commonApi', () => {
  test('calls api with correct user agent', async () => {
    const client = createClient();

    const result = (await client.customPost({
      path: '1/test',
    })) as unknown as EchoResponse;

    expect(decodeURIComponent(result.algoliaAgent)).toMatch(
      /^Algolia for JavaScript \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Abtesting (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$/
    );
  }, 15000);

  test('calls api with default read timeouts', async () => {
    const client = createClient();

    const result = (await client.customGet({
      path: '1/test',
    })) as unknown as EchoResponse;

    expect(result).toEqual(
      expect.objectContaining({ connectTimeout: 2000, responseTimeout: 5000 })
    );
  }, 15000);

  test('calls api with default write timeouts', async () => {
    const client = createClient();

    const result = (await client.customPost({
      path: '1/test',
    })) as unknown as EchoResponse;

    expect(result).toEqual(
      expect.objectContaining({ connectTimeout: 2000, responseTimeout: 30000 })
    );
  }, 15000);
});

describe('parameters', () => {
  test('fallbacks to the alias when region is not given', async () => {
    const client = abtestingClient('my-app-id', 'my-api-key', '', {
      requester: echoRequester(),
    });

    const result = (await client.getABTest({
      id: 123,
    })) as unknown as EchoResponse;

    expect(result.host).toEqual('analytics.algolia.com');
  }, 15000);

  test('uses the correct region', async () => {
    const client = abtestingClient('my-app-id', 'my-api-key', 'us', {
      requester: echoRequester(),
    });

    const result = (await client.getABTest({
      id: 123,
    })) as unknown as EchoResponse;

    expect(result.host).toEqual('analytics.us.algolia.com');
  }, 15000);

  test('throws when incorrect region is given', async () => {
    try {
      const client = abtestingClient(
        'my-app-id',
        'my-api-key',
        'not_a_region',
        { requester: echoRequester() }
      );
      throw new Error('test is expected to throw error');
    } catch (e) {
      expect((e as Error).message).toMatch(
        '`region` must be one of the following: de, us'
      );
    }
  }, 15000);
});

describe('init', () => {
  test('sets authMode', async () => {
    const qpClient = abtestingClient('foo', 'bar', 'us', {
      authMode: 'WithinQueryParameters',
      requester: echoRequester(),
    });
    const headerClient = abtestingClient('foo', 'bar', 'us', {
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
