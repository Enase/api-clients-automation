<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Recommend;

/**
 * AlternativesAsExact Class Doc Comment.
 *
 * @category Class
 */
class AlternativesAsExact
{
    /**
     * Possible values of this enum.
     */
    public const IGNORE_PLURALS = 'ignorePlurals';

    public const SINGLE_WORD_SYNONYM = 'singleWordSynonym';

    public const MULTI_WORDS_SYNONYM = 'multiWordsSynonym';

    public const IGNORE_CONJUGATIONS = 'ignoreConjugations';

    /**
     * Gets allowable values of the enum.
     *
     * @return string[]
     */
    public static function getAllowableEnumValues()
    {
        return [
            self::IGNORE_PLURALS,
            self::SINGLE_WORD_SYNONYM,
            self::MULTI_WORDS_SYNONYM,
            self::IGNORE_CONJUGATIONS,
        ];
    }
}
