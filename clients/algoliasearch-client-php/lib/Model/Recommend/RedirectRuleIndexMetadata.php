<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Recommend;

/**
 * RedirectRuleIndexMetadata Class Doc Comment.
 *
 * @category Class
 */
class RedirectRuleIndexMetadata extends \Algolia\AlgoliaSearch\Model\AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'source' => 'string',
        'dest' => 'string',
        'reason' => 'string',
        'succeed' => 'bool',
        'data' => '\Algolia\AlgoliaSearch\Model\Recommend\RedirectRuleIndexMetadataData',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'source' => null,
        'dest' => null,
        'reason' => null,
        'succeed' => null,
        'data' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'source' => 'source',
        'dest' => 'dest',
        'reason' => 'reason',
        'succeed' => 'succeed',
        'data' => 'data',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'source' => 'setSource',
        'dest' => 'setDest',
        'reason' => 'setReason',
        'succeed' => 'setSucceed',
        'data' => 'setData',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'source' => 'getSource',
        'dest' => 'getDest',
        'reason' => 'getReason',
        'succeed' => 'getSucceed',
        'data' => 'getData',
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
    public function __construct(array $data = null)
    {
        if (isset($data['source'])) {
            $this->container['source'] = $data['source'];
        }
        if (isset($data['dest'])) {
            $this->container['dest'] = $data['dest'];
        }
        if (isset($data['reason'])) {
            $this->container['reason'] = $data['reason'];
        }
        if (isset($data['succeed'])) {
            $this->container['succeed'] = $data['succeed'];
        }
        if (isset($data['data'])) {
            $this->container['data'] = $data['data'];
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

        if (!isset($this->container['source']) || null === $this->container['source']) {
            $invalidProperties[] = "'source' can't be null";
        }
        if (!isset($this->container['dest']) || null === $this->container['dest']) {
            $invalidProperties[] = "'dest' can't be null";
        }
        if (!isset($this->container['reason']) || null === $this->container['reason']) {
            $invalidProperties[] = "'reason' can't be null";
        }
        if (!isset($this->container['succeed']) || null === $this->container['succeed']) {
            $invalidProperties[] = "'succeed' can't be null";
        }
        if (!isset($this->container['data']) || null === $this->container['data']) {
            $invalidProperties[] = "'data' can't be null";
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
     * Gets source.
     *
     * @return string
     */
    public function getSource()
    {
        return $this->container['source'] ?? null;
    }

    /**
     * Sets source.
     *
     * @param string $source source index for the redirect rule
     *
     * @return self
     */
    public function setSource($source)
    {
        $this->container['source'] = $source;

        return $this;
    }

    /**
     * Gets dest.
     *
     * @return string
     */
    public function getDest()
    {
        return $this->container['dest'] ?? null;
    }

    /**
     * Sets dest.
     *
     * @param string $dest destination index for the redirect rule
     *
     * @return self
     */
    public function setDest($dest)
    {
        $this->container['dest'] = $dest;

        return $this;
    }

    /**
     * Gets reason.
     *
     * @return string
     */
    public function getReason()
    {
        return $this->container['reason'] ?? null;
    }

    /**
     * Sets reason.
     *
     * @param string $reason reason for the redirect rule
     *
     * @return self
     */
    public function setReason($reason)
    {
        $this->container['reason'] = $reason;

        return $this;
    }

    /**
     * Gets succeed.
     *
     * @return bool
     */
    public function getSucceed()
    {
        return $this->container['succeed'] ?? null;
    }

    /**
     * Sets succeed.
     *
     * @param bool $succeed redirect rule status
     *
     * @return self
     */
    public function setSucceed($succeed)
    {
        $this->container['succeed'] = $succeed;

        return $this;
    }

    /**
     * Gets data.
     *
     * @return RedirectRuleIndexMetadataData
     */
    public function getData()
    {
        return $this->container['data'] ?? null;
    }

    /**
     * Sets data.
     *
     * @param RedirectRuleIndexMetadataData $data data
     *
     * @return self
     */
    public function setData($data)
    {
        $this->container['data'] = $data;

        return $this;
    }

    /**
     * Returns true if offset exists. False otherwise.
     *
     * @param int $offset Offset
     *
     * @return bool
     */
    public function offsetExists($offset)
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
    public function offsetGet($offset)
    {
        return $this->container[$offset] ?? null;
    }

    /**
     * Sets value based on offset.
     *
     * @param null|int $offset Offset
     * @param mixed    $value  Value to be set
     */
    public function offsetSet($offset, $value)
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
    public function offsetUnset($offset)
    {
        unset($this->container[$offset]);
    }
}
