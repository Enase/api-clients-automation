// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
/* eslint-disable eslint/no-unused-vars */
import { describe, expect, test } from 'vitest';

import type { EchoResponse } from '@algolia/requester-testing';
import { nodeEchoRequester } from '@algolia/requester-testing';
import { algoliasearch } from 'algoliasearch';

const appId = 'test-app-id';
const apiKey = 'test-api-key';

function createClient() {
  return algoliasearch(appId, apiKey).initInsights({ options: { requester: nodeEchoRequester() }, region: 'us' });
}

describe('commonApi', () => {
  test('calls api with correct user agent', async () => {
    const client = createClient();

    const result = (await client.customPost({ path: '1/test' })) as unknown as EchoResponse;

    expect(decodeURIComponent(result.algoliaAgent)).toMatch(
      /^Algolia for JavaScript \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Insights (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$/,
    );
  }, 15000);

  test('the user agent contains the latest version', async () => {
    const client = createClient();

    const result = (await client.customPost({ path: '1/test' })) as unknown as EchoResponse;

    expect(decodeURIComponent(result.algoliaAgent)).toMatch(/^Algolia for JavaScript \(5.20.0\).*/);
  }, 15000);
});

describe('parameters', () => {
  test('fallbacks to the alias when region is not given', async () => {
    const client = algoliasearch('my-app-id', 'my-api-key').initInsights({
      options: {
        requester: nodeEchoRequester(),
      },
      // @ts-ignore
      region: '',
    });
    const result = (await client.pushEvents({
      events: [
        {
          eventType: 'click',
          eventName: 'Product Clicked',
          index: 'products',
          userToken: 'user-123456',
          authenticatedUserToken: 'user-123456',
          timestamp: 1641290601962,
          objectIDs: ['9780545139700', '9780439784542'],
          queryID: '43b15df305339e827f0ac0bdc5ebcaa7',
          positions: [7, 6],
        },
      ],
    })) as unknown as EchoResponse;

    expect(result.host).toEqual('insights.algolia.io');
  }, 15000);

  test('uses the correct region', async () => {
    const client = algoliasearch('my-app-id', 'my-api-key').initInsights({
      options: {
        requester: nodeEchoRequester(),
      },
      // @ts-ignore
      region: 'us',
    });
    const result = (await client.customDelete({ path: 'test' })) as unknown as EchoResponse;

    expect(result.host).toEqual('insights.us.algolia.io');
  }, 15000);

  test('throws when incorrect region is given', async () => {
    try {
      // @ts-ignore
      const client = algoliasearch('my-app-id', 'my-api-key').initInsights({
        options: {
          requester: nodeEchoRequester(),
        },
        // @ts-ignore
        region: 'not_a_region',
      });
      throw new Error('test is expected to throw error');
    } catch (e) {
      expect((e as Error).message).toMatch('`region` must be one of the following: de, us');
    }
  }, 15000);
});

describe('setClientApiKey', () => {
  test('switch API key', async () => {
    const client = algoliasearch('test-app-id', 'test-api-key').initInsights({
      options: {
        hosts: [
          {
            url: 'localhost',
            port: 6683,
            accept: 'readWrite',
            protocol: 'http',
          },
        ],
      },
      // @ts-ignore
      region: 'us',
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
    const qpClient = algoliasearch('foo', 'bar').initInsights({
      options: { requester: nodeEchoRequester(), authMode: 'WithinQueryParameters' },
      region: 'us',
    });
    const headerClient = algoliasearch('foo', 'bar').initInsights({
      options: { requester: nodeEchoRequester(), authMode: 'WithinHeaders' },
      region: 'us',
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
