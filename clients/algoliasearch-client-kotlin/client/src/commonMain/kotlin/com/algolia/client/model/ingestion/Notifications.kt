/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Notifications settings for a task.
 *
 * @param email
 */
@Serializable
public data class Notifications(

  @SerialName(value = "email") val email: EmailNotifications,
)
