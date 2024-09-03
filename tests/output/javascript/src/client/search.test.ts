// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
/* eslint-disable @typescript-eslint/no-unused-vars, require-await */
// @ts-nocheck Failing tests will have type errors, but we cannot suppress them even with @ts-expect-error because it doesn't work for a block of lines.
import type { SearchClient } from '@algolia/client-search';
import { searchClient } from '@algolia/client-search';
import { echoRequester } from '@algolia/requester-node-http';
import type { EchoResponse } from '@algolia/requester-node-http';

const appId = 'test-app-id';
const apiKey = 'test-api-key';

function createClient(): SearchClient {
  return searchClient(appId, apiKey, { requester: echoRequester() });
}

describe('api', () => {
  test('calls api with correct read host', async () => {
    const client = searchClient('test-app-id', 'test-api-key', { requester: echoRequester() });

    const result = (await client.customGet({ path: 'test' })) as unknown as EchoResponse;

    expect(result.host).toEqual('test-app-id-dsn.algolia.net');
  }, 15000);

  test('calls api with correct write host', async () => {
    const client = searchClient('test-app-id', 'test-api-key', { requester: echoRequester() });

    const result = (await client.customPost({ path: 'test' })) as unknown as EchoResponse;

    expect(result.host).toEqual('test-app-id.algolia.net');
  }, 15000);

  test('tests the retry strategy', async () => {
    const client = searchClient('test-app-id', 'test-api-key', {
      hosts: [
        { url: 'localhost', port: 6676, accept: 'readWrite', protocol: 'http' },
        { url: 'localhost', port: 6677, accept: 'readWrite', protocol: 'http' },
        { url: 'localhost', port: 6678, accept: 'readWrite', protocol: 'http' },
      ],
    });

    const result = await client.customGet({ path: '1/test/retry/javascript' });

    expect(result).toEqual({ message: 'ok test server response' });
  }, 15000);

  test('tests the retry strategy error', async () => {
    const client = searchClient('test-app-id', 'test-api-key', {
      hosts: [{ url: 'localhost', port: 6676, accept: 'readWrite', protocol: 'http' }],
    });

    try {
      const result = await client.customGet({ path: '1/test/hang/javascript' });
      throw new Error('test is expected to throw error');
    } catch (e) {
      expect((e as Error).message).toMatch(
        'Unreachable hosts - your application id may be incorrect. If the error persists, please reach out to the Algolia Support team: https://alg.li/support.',
      );
    }
  }, 15000);
});

describe('commonApi', () => {
  test('calls api with correct user agent', async () => {
    const client = createClient();

    const result = (await client.customPost({ path: '1/test' })) as unknown as EchoResponse;

    expect(decodeURIComponent(result.algoliaAgent)).toMatch(
      /^Algolia for JavaScript \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Search (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$/,
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

describe('deleteObjects', () => {
  test('call deleteObjects without error', async () => {
    const client = searchClient('test-app-id', 'test-api-key', {
      hosts: [{ url: 'localhost', port: 6680, accept: 'readWrite', protocol: 'http' }],
    });

    const result = await client.deleteObjects({ indexName: 'cts_e2e_deleteObjects_javascript', objectIDs: ['1', '2'] });

    expect(result).toEqual([{ taskID: 666, objectIDs: ['1', '2'] }]);
  }, 15000);
});

describe('generateSecuredApiKey', () => {
  test('generate secured api key basic', async () => {
    const client = createClient();

    const result = client.generateSecuredApiKey({
      parentApiKey: '2640659426d5107b6e47d75db9cbaef8',
      restrictions: { validUntil: 2524604400, restrictIndices: ['Movies'] },
    });

    expect(result).toEqual(
      'NjFhZmE0OGEyMTI3OThiODc0OTlkOGM0YjcxYzljY2M2NmU2NDE5ZWY0NDZjMWJhNjA2NzBkMjAwOTI2YWQyZnJlc3RyaWN0SW5kaWNlcz1Nb3ZpZXMmdmFsaWRVbnRpbD0yNTI0NjA0NDAw',
    );
  }, 15000);

  test('generate secured api key with searchParams', async () => {
    const client = createClient();

    const result = client.generateSecuredApiKey({
      parentApiKey: '2640659426d5107b6e47d75db9cbaef8',
      restrictions: {
        validUntil: 2524604400,
        restrictIndices: ['Movies', 'cts_e2e_settings'],
        restrictSources: '192.168.1.0/24',
        filters: 'category:Book OR category:Ebook AND _tags:published',
        userToken: 'user123',
        searchParams: {
          query: 'batman',
          typoTolerance: 'strict',
          aroundRadius: 'all',
          mode: 'neuralSearch',
          hitsPerPage: 10,
          optionalWords: ['one', 'two'],
        },
      },
    });

    expect(result).toEqual(
      'MzAxMDUwYjYyODMxODQ3ZWM1ZDYzNTkxZmNjNDg2OGZjMjAzYjQyOTZhMGQ1NDJhMDFiNGMzYTYzODRhNmMxZWFyb3VuZFJhZGl1cz1hbGwmZmlsdGVycz1jYXRlZ29yeSUzQUJvb2slMjBPUiUyMGNhdGVnb3J5JTNBRWJvb2slMjBBTkQlMjBfdGFncyUzQXB1Ymxpc2hlZCZoaXRzUGVyUGFnZT0xMCZtb2RlPW5ldXJhbFNlYXJjaCZvcHRpb25hbFdvcmRzPW9uZSUyQ3R3byZxdWVyeT1iYXRtYW4mcmVzdHJpY3RJbmRpY2VzPU1vdmllcyUyQ2N0c19lMmVfc2V0dGluZ3MmcmVzdHJpY3RTb3VyY2VzPTE5Mi4xNjguMS4wJTJGMjQmdHlwb1RvbGVyYW5jZT1zdHJpY3QmdXNlclRva2VuPXVzZXIxMjMmdmFsaWRVbnRpbD0yNTI0NjA0NDAw',
    );
  }, 15000);
});

describe('parameters', () => {
  test('client throws with invalid parameters', async () => {
    try {
      const client = searchClient('', '', { requester: echoRequester() });
      throw new Error('test is expected to throw error');
    } catch (e) {
      expect((e as Error).message).toMatch('`appId` is missing.');
    }
    try {
      const client = searchClient('', 'my-api-key', { requester: echoRequester() });
      throw new Error('test is expected to throw error');
    } catch (e) {
      expect((e as Error).message).toMatch('`appId` is missing.');
    }
    try {
      const client = searchClient('my-app-id', '', { requester: echoRequester() });
      throw new Error('test is expected to throw error');
    } catch (e) {
      expect((e as Error).message).toMatch('`apiKey` is missing.');
    }
  }, 15000);

  test('`addApiKey` throws with invalid parameters', async () => {
    const client = createClient();

    try {
      const result = (await client.addApiKey(null)) as unknown as EchoResponse;
      throw new Error('test is expected to throw error');
    } catch (e) {
      expect((e as Error).message).toMatch('Parameter `apiKey` is required when calling `addApiKey`.');
    }
  }, 15000);

  test('`addOrUpdateObject` throws with invalid parameters', async () => {
    const client = createClient();

    try {
      const result = (await client.addOrUpdateObject({
        objectID: 'my-object-id',
        body: {},
      })) as unknown as EchoResponse;
      throw new Error('test is expected to throw error');
    } catch (e) {
      expect((e as Error).message).toMatch('Parameter `indexName` is required when calling `addOrUpdateObject`.');
    }
    try {
      const result = (await client.addOrUpdateObject({
        indexName: 'my-index-name',
        body: {},
      })) as unknown as EchoResponse;
      throw new Error('test is expected to throw error');
    } catch (e) {
      expect((e as Error).message).toMatch('Parameter `objectID` is required when calling `addOrUpdateObject`.');
    }
    try {
      const result = (await client.addOrUpdateObject({
        indexName: 'my-index-name',
        objectID: 'my-object-id',
      })) as unknown as EchoResponse;
      throw new Error('test is expected to throw error');
    } catch (e) {
      expect((e as Error).message).toMatch('Parameter `body` is required when calling `addOrUpdateObject`.');
    }
  }, 15000);
});

describe('partialUpdateObjects', () => {
  test('call partialUpdateObjects with createIfNotExists=true', async () => {
    const client = searchClient('test-app-id', 'test-api-key', {
      hosts: [{ url: 'localhost', port: 6680, accept: 'readWrite', protocol: 'http' }],
    });

    const result = await client.partialUpdateObjects({
      indexName: 'cts_e2e_partialUpdateObjects_javascript',
      objects: [
        { objectID: '1', name: 'Adam' },
        { objectID: '2', name: 'Benoit' },
      ],
      createIfNotExists: true,
    });

    expect(result).toEqual([{ taskID: 444, objectIDs: ['1', '2'] }]);
  }, 15000);

  test('call partialUpdateObjects with createIfNotExists=false', async () => {
    const client = searchClient('test-app-id', 'test-api-key', {
      hosts: [{ url: 'localhost', port: 6680, accept: 'readWrite', protocol: 'http' }],
    });

    const result = await client.partialUpdateObjects({
      indexName: 'cts_e2e_partialUpdateObjects_javascript',
      objects: [
        { objectID: '3', name: 'Cyril' },
        { objectID: '4', name: 'David' },
      ],
      createIfNotExists: false,
    });

    expect(result).toEqual([{ taskID: 555, objectIDs: ['3', '4'] }]);
  }, 15000);
});

describe('replaceAllObjects', () => {
  test('call replaceAllObjects without error', async () => {
    const client = searchClient('test-app-id', 'test-api-key', {
      hosts: [{ url: 'localhost', port: 6679, accept: 'readWrite', protocol: 'http' }],
    });

    const result = await client.replaceAllObjects({
      indexName: 'cts_e2e_replace_all_objects_javascript',
      objects: [
        { objectID: '1', name: 'Adam' },
        { objectID: '2', name: 'Benoit' },
        { objectID: '3', name: 'Cyril' },
        { objectID: '4', name: 'David' },
        { objectID: '5', name: 'Eva' },
        { objectID: '6', name: 'Fiona' },
        { objectID: '7', name: 'Gael' },
        { objectID: '8', name: 'Hugo' },
        { objectID: '9', name: 'Igor' },
        { objectID: '10', name: 'Julia' },
      ],
      batchSize: 3,
    });

    expect(result).toEqual({
      copyOperationResponse: { taskID: 125, updatedAt: '2021-01-01T00:00:00.000Z' },
      batchResponses: [
        { taskID: 127, objectIDs: ['1', '2', '3'] },
        { taskID: 130, objectIDs: ['4', '5', '6'] },
        { taskID: 133, objectIDs: ['7', '8', '9'] },
        { taskID: 134, objectIDs: ['10'] },
      ],
      moveOperationResponse: { taskID: 777, updatedAt: '2021-01-01T00:00:00.000Z' },
    });
  }, 15000);
});

describe('saveObjects', () => {
  test('call saveObjects without error', async () => {
    const client = searchClient('test-app-id', 'test-api-key', {
      hosts: [{ url: 'localhost', port: 6680, accept: 'readWrite', protocol: 'http' }],
    });

    const result = await client.saveObjects({
      indexName: 'cts_e2e_saveObjects_javascript',
      objects: [
        { objectID: '1', name: 'Adam' },
        { objectID: '2', name: 'Benoit' },
      ],
    });

    expect(result).toEqual([{ taskID: 333, objectIDs: ['1', '2'] }]);
  }, 15000);

  test('saveObjects should report errors', async () => {
    const client = searchClient('test-app-id', 'wrong-api-key', {
      hosts: [{ url: 'localhost', port: 6680, accept: 'readWrite', protocol: 'http' }],
    });

    try {
      const result = await client.saveObjects({
        indexName: 'cts_e2e_saveObjects_javascript',
        objects: [
          { objectID: '1', name: 'Adam' },
          { objectID: '2', name: 'Benoit' },
        ],
      });
      throw new Error('test is expected to throw error');
    } catch (e) {
      expect((e as Error).message).toMatch('Invalid Application-ID or API key');
    }
  }, 15000);
});

describe('waitForApiKey', () => {
  test('wait for api key helper - add', async () => {
    const client = searchClient('test-app-id', 'test-api-key', {
      hosts: [{ url: 'localhost', port: 6681, accept: 'readWrite', protocol: 'http' }],
    });

    const result = await client.waitForApiKey({ key: 'api-key-add-operation-test-javascript', operation: 'add' });

    expect(result).toEqual({
      value: 'api-key-add-operation-test-javascript',
      description: 'my new api key',
      acl: ['search', 'addObject'],
      validity: 300,
      maxQueriesPerIPPerHour: 100,
      maxHitsPerQuery: 20,
      createdAt: 1720094400,
    });
  }, 15000);

  test('wait for api key - update', async () => {
    const client = searchClient('test-app-id', 'test-api-key', {
      hosts: [{ url: 'localhost', port: 6681, accept: 'readWrite', protocol: 'http' }],
    });

    const result = await client.waitForApiKey({
      key: 'api-key-update-operation-test-javascript',
      operation: 'update',
      apiKey: {
        description: 'my updated api key',
        acl: ['search', 'addObject', 'deleteObject'],
        indexes: ['Movies', 'Books'],
        referers: ['*google.com', '*algolia.com'],
        validity: 305,
        maxQueriesPerIPPerHour: 95,
        maxHitsPerQuery: 20,
      },
    });

    expect(result).toEqual({
      value: 'api-key-update-operation-test-javascript',
      description: 'my updated api key',
      acl: ['search', 'addObject', 'deleteObject'],
      indexes: ['Movies', 'Books'],
      referers: ['*google.com', '*algolia.com'],
      validity: 305,
      maxQueriesPerIPPerHour: 95,
      maxHitsPerQuery: 20,
      createdAt: 1720094400,
    });
  }, 15000);

  test('wait for api key - delete', async () => {
    const client = searchClient('test-app-id', 'test-api-key', {
      hosts: [{ url: 'localhost', port: 6681, accept: 'readWrite', protocol: 'http' }],
    });

    const result = await client.waitForApiKey({ key: 'api-key-delete-operation-test-javascript', operation: 'delete' });

    expect(result).toBeUndefined();
  }, 15000);
});

describe('waitForAppTask', () => {
  test('wait for an application-level task', async () => {
    const client = searchClient('test-app-id', 'test-api-key', {
      hosts: [{ url: 'localhost', port: 6681, accept: 'readWrite', protocol: 'http' }],
    });

    const result = await client.waitForAppTask({ taskID: 123 });

    expect(result).toEqual({ status: 'published' });
  }, 15000);
});

describe('waitForTask', () => {
  test('wait for task', async () => {
    const client = searchClient('test-app-id', 'test-api-key', {
      hosts: [{ url: 'localhost', port: 6681, accept: 'readWrite', protocol: 'http' }],
    });

    const result = await client.waitForTask({ indexName: 'wait-task-javascript', taskID: 123 });

    expect(result).toEqual({ status: 'published' });
  }, 15000);
});

describe('init', () => {
  test('sets authMode', async () => {
    const qpClient = searchClient('foo', 'bar', {
      authMode: 'WithinQueryParameters',
      requester: echoRequester(),
    });
    const headerClient = searchClient('foo', 'bar', {
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
