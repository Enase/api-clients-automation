<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Insights;

use Algolia\AlgoliaSearch\Model\AbstractModel;
use Algolia\AlgoliaSearch\Model\ModelInterface;

/**
 * EventsItems Class Doc Comment.
 *
 * @category Class
 */
class EventsItems extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'eventName' => 'string',
        'eventType' => '\Algolia\AlgoliaSearch\Model\Insights\ViewEvent',
        'index' => 'string',
        'objectIDs' => 'string[]',
        'positions' => 'int[]',
        'queryID' => 'string',
        'userToken' => 'string',
        'authenticatedUserToken' => 'string',
        'timestamp' => 'int',
        'eventSubtype' => '\Algolia\AlgoliaSearch\Model\Insights\AddToCartEvent',
        'currency' => 'string',
        'objectData' => '\Algolia\AlgoliaSearch\Model\Insights\ObjectData[]',
        'value' => '\Algolia\AlgoliaSearch\Model\Insights\Value',
        'filters' => 'string[]',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'eventName' => null,
        'eventType' => null,
        'index' => null,
        'objectIDs' => null,
        'positions' => null,
        'queryID' => null,
        'userToken' => null,
        'authenticatedUserToken' => null,
        'timestamp' => 'int64',
        'eventSubtype' => null,
        'currency' => null,
        'objectData' => null,
        'value' => null,
        'filters' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'eventName' => 'eventName',
        'eventType' => 'eventType',
        'index' => 'index',
        'objectIDs' => 'objectIDs',
        'positions' => 'positions',
        'queryID' => 'queryID',
        'userToken' => 'userToken',
        'authenticatedUserToken' => 'authenticatedUserToken',
        'timestamp' => 'timestamp',
        'eventSubtype' => 'eventSubtype',
        'currency' => 'currency',
        'objectData' => 'objectData',
        'value' => 'value',
        'filters' => 'filters',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'eventName' => 'setEventName',
        'eventType' => 'setEventType',
        'index' => 'setIndex',
        'objectIDs' => 'setObjectIDs',
        'positions' => 'setPositions',
        'queryID' => 'setQueryID',
        'userToken' => 'setUserToken',
        'authenticatedUserToken' => 'setAuthenticatedUserToken',
        'timestamp' => 'setTimestamp',
        'eventSubtype' => 'setEventSubtype',
        'currency' => 'setCurrency',
        'objectData' => 'setObjectData',
        'value' => 'setValue',
        'filters' => 'setFilters',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'eventName' => 'getEventName',
        'eventType' => 'getEventType',
        'index' => 'getIndex',
        'objectIDs' => 'getObjectIDs',
        'positions' => 'getPositions',
        'queryID' => 'getQueryID',
        'userToken' => 'getUserToken',
        'authenticatedUserToken' => 'getAuthenticatedUserToken',
        'timestamp' => 'getTimestamp',
        'eventSubtype' => 'getEventSubtype',
        'currency' => 'getCurrency',
        'objectData' => 'getObjectData',
        'value' => 'getValue',
        'filters' => 'getFilters',
    ];

    /**
     * Associative array for storing property values.
     *
     * @var mixed[]
     */
    protected $container = [];

    /**
     * Constructor.
     *
     * @param mixed[] $data Associated array of property values
     */
    public function __construct(?array $data = null)
    {
        if (isset($data['eventName'])) {
            $this->container['eventName'] = $data['eventName'];
        }
        if (isset($data['eventType'])) {
            $this->container['eventType'] = $data['eventType'];
        }
        if (isset($data['index'])) {
            $this->container['index'] = $data['index'];
        }
        if (isset($data['objectIDs'])) {
            $this->container['objectIDs'] = $data['objectIDs'];
        }
        if (isset($data['positions'])) {
            $this->container['positions'] = $data['positions'];
        }
        if (isset($data['queryID'])) {
            $this->container['queryID'] = $data['queryID'];
        }
        if (isset($data['userToken'])) {
            $this->container['userToken'] = $data['userToken'];
        }
        if (isset($data['authenticatedUserToken'])) {
            $this->container['authenticatedUserToken'] = $data['authenticatedUserToken'];
        }
        if (isset($data['timestamp'])) {
            $this->container['timestamp'] = $data['timestamp'];
        }
        if (isset($data['eventSubtype'])) {
            $this->container['eventSubtype'] = $data['eventSubtype'];
        }
        if (isset($data['currency'])) {
            $this->container['currency'] = $data['currency'];
        }
        if (isset($data['objectData'])) {
            $this->container['objectData'] = $data['objectData'];
        }
        if (isset($data['value'])) {
            $this->container['value'] = $data['value'];
        }
        if (isset($data['filters'])) {
            $this->container['filters'] = $data['filters'];
        }
    }

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @return array
     */
    public static function attributeMap()
    {
        return self::$attributeMap;
    }

    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @return array
     */
    public static function modelTypes()
    {
        return self::$modelTypes;
    }

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @return array
     */
    public static function modelFormats()
    {
        return self::$modelFormats;
    }

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @return array
     */
    public static function setters()
    {
        return self::$setters;
    }

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @return array
     */
    public static function getters()
    {
        return self::$getters;
    }

    /**
     * Show all the invalid properties with reasons.
     *
     * @return array invalid properties with reasons
     */
    public function listInvalidProperties()
    {
        $invalidProperties = [];

        if (!isset($this->container['eventName']) || null === $this->container['eventName']) {
            $invalidProperties[] = "'eventName' can't be null";
        }
        if (!isset($this->container['eventType']) || null === $this->container['eventType']) {
            $invalidProperties[] = "'eventType' can't be null";
        }
        if (!isset($this->container['index']) || null === $this->container['index']) {
            $invalidProperties[] = "'index' can't be null";
        }
        if (!isset($this->container['objectIDs']) || null === $this->container['objectIDs']) {
            $invalidProperties[] = "'objectIDs' can't be null";
        }
        if (!isset($this->container['positions']) || null === $this->container['positions']) {
            $invalidProperties[] = "'positions' can't be null";
        }
        if (!isset($this->container['queryID']) || null === $this->container['queryID']) {
            $invalidProperties[] = "'queryID' can't be null";
        }
        if (!isset($this->container['userToken']) || null === $this->container['userToken']) {
            $invalidProperties[] = "'userToken' can't be null";
        }
        if (!isset($this->container['eventSubtype']) || null === $this->container['eventSubtype']) {
            $invalidProperties[] = "'eventSubtype' can't be null";
        }
        if (!isset($this->container['objectData']) || null === $this->container['objectData']) {
            $invalidProperties[] = "'objectData' can't be null";
        }
        if (!isset($this->container['filters']) || null === $this->container['filters']) {
            $invalidProperties[] = "'filters' can't be null";
        }

        return $invalidProperties;
    }

    /**
     * Validate all the properties in the model
     * return true if all passed.
     *
     * @return bool True if all properties are valid
     */
    public function valid()
    {
        return 0 === count($this->listInvalidProperties());
    }

    /**
     * Gets eventName.
     *
     * @return string
     */
    public function getEventName()
    {
        return $this->container['eventName'] ?? null;
    }

    /**
     * Sets eventName.
     *
     * @param string $eventName Event name, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework.
     *
     * @return self
     */
    public function setEventName($eventName)
    {
        $this->container['eventName'] = $eventName;

        return $this;
    }

    /**
     * Gets eventType.
     *
     * @return ViewEvent
     */
    public function getEventType()
    {
        return $this->container['eventType'] ?? null;
    }

    /**
     * Sets eventType.
     *
     * @param ViewEvent $eventType eventType
     *
     * @return self
     */
    public function setEventType($eventType)
    {
        $this->container['eventType'] = $eventType;

        return $this;
    }

    /**
     * Gets index.
     *
     * @return string
     */
    public function getIndex()
    {
        return $this->container['index'] ?? null;
    }

    /**
     * Sets index.
     *
     * @param string $index index name (case-sensitive) to which the event's items belong
     *
     * @return self
     */
    public function setIndex($index)
    {
        $this->container['index'] = $index;

        return $this;
    }

    /**
     * Gets objectIDs.
     *
     * @return string[]
     */
    public function getObjectIDs()
    {
        return $this->container['objectIDs'] ?? null;
    }

    /**
     * Sets objectIDs.
     *
     * @param string[] $objectIDs object IDs of the records that are part of the event
     *
     * @return self
     */
    public function setObjectIDs($objectIDs)
    {
        $this->container['objectIDs'] = $objectIDs;

        return $this;
    }

    /**
     * Gets positions.
     *
     * @return int[]
     */
    public function getPositions()
    {
        return $this->container['positions'] ?? null;
    }

    /**
     * Sets positions.
     *
     * @param int[] $positions Position of the clicked item the search results.  You must provide 1 `position` for each `objectID`.
     *
     * @return self
     */
    public function setPositions($positions)
    {
        $this->container['positions'] = $positions;

        return $this;
    }

    /**
     * Gets queryID.
     *
     * @return string
     */
    public function getQueryID()
    {
        return $this->container['queryID'] ?? null;
    }

    /**
     * Sets queryID.
     *
     * @param string $queryID Unique identifier for a search query.  The query ID is required for events related to search or browse requests. If you add `clickAnalytics: true` as a search request parameter, the query ID is included in the API response.
     *
     * @return self
     */
    public function setQueryID($queryID)
    {
        $this->container['queryID'] = $queryID;

        return $this;
    }

    /**
     * Gets userToken.
     *
     * @return string
     */
    public function getUserToken()
    {
        return $this->container['userToken'] ?? null;
    }

    /**
     * Sets userToken.
     *
     * @param string $userToken Anonymous or pseudonymous user identifier.  Don't use personally identifiable information in user tokens. For more information, see [User token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).
     *
     * @return self
     */
    public function setUserToken($userToken)
    {
        $this->container['userToken'] = $userToken;

        return $this;
    }

    /**
     * Gets authenticatedUserToken.
     *
     * @return null|string
     */
    public function getAuthenticatedUserToken()
    {
        return $this->container['authenticatedUserToken'] ?? null;
    }

    /**
     * Sets authenticatedUserToken.
     *
     * @param null|string $authenticatedUserToken Identifier for authenticated users.  When the user signs in, you can get an identifier from your system and send it as `authenticatedUserToken`. This lets you keep using the `userToken` from before the user signed in, while providing a reliable way to identify users across sessions. Don't use personally identifiable information in user tokens. For more information, see [User token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).
     *
     * @return self
     */
    public function setAuthenticatedUserToken($authenticatedUserToken)
    {
        $this->container['authenticatedUserToken'] = $authenticatedUserToken;

        return $this;
    }

    /**
     * Gets timestamp.
     *
     * @return null|int
     */
    public function getTimestamp()
    {
        return $this->container['timestamp'] ?? null;
    }

    /**
     * Sets timestamp.
     *
     * @param null|int $timestamp Timestamp of the event, measured in milliseconds since the Unix epoch. By default, the Insights API uses the time it receives an event as its timestamp.
     *
     * @return self
     */
    public function setTimestamp($timestamp)
    {
        $this->container['timestamp'] = $timestamp;

        return $this;
    }

    /**
     * Gets eventSubtype.
     *
     * @return AddToCartEvent
     */
    public function getEventSubtype()
    {
        return $this->container['eventSubtype'] ?? null;
    }

    /**
     * Sets eventSubtype.
     *
     * @param AddToCartEvent $eventSubtype eventSubtype
     *
     * @return self
     */
    public function setEventSubtype($eventSubtype)
    {
        $this->container['eventSubtype'] = $eventSubtype;

        return $this;
    }

    /**
     * Gets currency.
     *
     * @return null|string
     */
    public function getCurrency()
    {
        return $this->container['currency'] ?? null;
    }

    /**
     * Sets currency.
     *
     * @param null|string $currency Three-letter [currency code](https://www.iso.org/iso-4217-currency-codes.html).
     *
     * @return self
     */
    public function setCurrency($currency)
    {
        $this->container['currency'] = $currency;

        return $this;
    }

    /**
     * Gets objectData.
     *
     * @return ObjectData[]
     */
    public function getObjectData()
    {
        return $this->container['objectData'] ?? null;
    }

    /**
     * Sets objectData.
     *
     * @param ObjectData[] $objectData Extra information about the records involved in a purchase or add-to-cart event.  If specified, it must have the same length as `objectIDs`.
     *
     * @return self
     */
    public function setObjectData($objectData)
    {
        $this->container['objectData'] = $objectData;

        return $this;
    }

    /**
     * Gets value.
     *
     * @return null|Value
     */
    public function getValue()
    {
        return $this->container['value'] ?? null;
    }

    /**
     * Sets value.
     *
     * @param null|Value $value value
     *
     * @return self
     */
    public function setValue($value)
    {
        $this->container['value'] = $value;

        return $this;
    }

    /**
     * Gets filters.
     *
     * @return string[]
     */
    public function getFilters()
    {
        return $this->container['filters'] ?? null;
    }

    /**
     * Sets filters.
     *
     * @param string[] $filters Applied facet filters.  Facet filters are `facet:value` pairs. Facet values must be URL-encoded, such as, `discount:10%25`.
     *
     * @return self
     */
    public function setFilters($filters)
    {
        $this->container['filters'] = $filters;

        return $this;
    }

    /**
     * Returns true if offset exists. False otherwise.
     *
     * @param int $offset Offset
     */
    public function offsetExists($offset): bool
    {
        return isset($this->container[$offset]);
    }

    /**
     * Gets offset.
     *
     * @param int $offset Offset
     *
     * @return null|mixed
     */
    public function offsetGet($offset): mixed
    {
        return $this->container[$offset] ?? null;
    }

    /**
     * Sets value based on offset.
     *
     * @param null|int $offset Offset
     * @param mixed    $value  Value to be set
     */
    public function offsetSet($offset, $value): void
    {
        if (is_null($offset)) {
            $this->container[] = $value;
        } else {
            $this->container[$offset] = $value;
        }
    }

    /**
     * Unsets offset.
     *
     * @param int $offset Offset
     */
    public function offsetUnset($offset): void
    {
        unset($this->container[$offset]);
    }
}
