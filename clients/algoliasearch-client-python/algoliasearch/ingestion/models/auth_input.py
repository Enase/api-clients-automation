# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import dumps, loads
from sys import version_info
from typing import Any, Dict, Optional, Set, Union

from pydantic import BaseModel, Field, ValidationError, model_serializer

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


from algoliasearch.ingestion.models.auth_algolia import AuthAlgolia
from algoliasearch.ingestion.models.auth_algolia_insights import AuthAlgoliaInsights
from algoliasearch.ingestion.models.auth_api_key import AuthAPIKey
from algoliasearch.ingestion.models.auth_basic import AuthBasic
from algoliasearch.ingestion.models.auth_google_service_account import (
    AuthGoogleServiceAccount,
)
from algoliasearch.ingestion.models.auth_o_auth import AuthOAuth


class AuthInput(BaseModel):
    """
    AuthInput
    """

    oneof_schema_1_validator: Optional[AuthGoogleServiceAccount] = Field(default=None)

    oneof_schema_2_validator: Optional[AuthBasic] = Field(default=None)

    oneof_schema_3_validator: Optional[AuthAPIKey] = Field(default=None)

    oneof_schema_4_validator: Optional[AuthOAuth] = Field(default=None)

    oneof_schema_5_validator: Optional[AuthAlgolia] = Field(default=None)

    oneof_schema_6_validator: Optional[AuthAlgoliaInsights] = Field(default=None)

    oneof_schema_7_validator: Optional[Dict[str, str]] = Field(default=None)
    """ A key:value authentication for your transformations. """
    actual_instance: Union[
        AuthAPIKey,
        AuthAlgolia,
        AuthAlgoliaInsights,
        AuthBasic,
        AuthGoogleServiceAccount,
        AuthOAuth,
        Dict[str, str],
        None,
    ] = None
    one_of_schemas: Set[str] = {
        "AuthAPIKey",
        "AuthAlgolia",
        "AuthAlgoliaInsights",
        "AuthBasic",
        "AuthGoogleServiceAccount",
        "AuthOAuth",
        "Dict[str, str]",
    }

    def __init__(self, *args, **kwargs) -> None:
        if args:
            if len(args) > 1:
                raise ValueError(
                    "If a position argument is used, only 1 is allowed to set `actual_instance`"
                )
            if kwargs:
                raise ValueError(
                    "If a position argument is used, keyword arguments cannot be used."
                )
            super().__init__(actual_instance=args[0])  # pyright: ignore
        else:
            super().__init__(**kwargs)

    @model_serializer
    def unwrap_actual_instance(
        self,
    ) -> Union[
        AuthAPIKey,
        AuthAlgolia,
        AuthAlgoliaInsights,
        AuthBasic,
        AuthGoogleServiceAccount,
        AuthOAuth,
        Dict[str, str],
        Self,
        None,
    ]:
        """
        Unwraps the `actual_instance` when calling the `to_json` method.
        """
        return self.actual_instance if hasattr(self, "actual_instance") else self

    @classmethod
    def from_dict(cls, obj: Union[str, Dict[str, Any]]) -> Self:
        """Create an instance of AuthInput from a JSON string"""
        return cls.from_json(dumps(obj))

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Returns the object represented by the json string"""
        instance = cls.model_construct()
        error_messages = []

        try:
            instance.actual_instance = AuthGoogleServiceAccount.from_json(json_str)

            return instance
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        try:
            instance.actual_instance = AuthBasic.from_json(json_str)

            return instance
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        try:
            instance.actual_instance = AuthAPIKey.from_json(json_str)

            return instance
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        try:
            instance.actual_instance = AuthOAuth.from_json(json_str)

            return instance
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        try:
            instance.actual_instance = AuthAlgolia.from_json(json_str)

            return instance
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        try:
            instance.actual_instance = AuthAlgoliaInsights.from_json(json_str)

            return instance
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        try:
            instance.oneof_schema_7_validator = loads(json_str)
            instance.actual_instance = instance.oneof_schema_7_validator

            return instance
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))

        raise ValueError(
            "No match found when deserializing the JSON string into AuthInput with oneOf schemas: AuthAPIKey, AuthAlgolia, AuthAlgoliaInsights, AuthBasic, AuthGoogleServiceAccount, AuthOAuth, Dict[str, str]. Details: "
            + ", ".join(error_messages)
        )

    def to_json(self) -> str:
        """Returns the JSON representation of the actual instance"""
        if self.actual_instance is None:
            return "null"

        if hasattr(self.actual_instance, "to_json") and callable(
            self.actual_instance.to_json  # pyright: ignore
        ):
            return self.actual_instance.to_json()  # pyright: ignore
        else:
            return dumps(self.actual_instance)

    def to_dict(
        self,
    ) -> Optional[
        Union[
            Dict[str, Any],
            AuthAPIKey,
            AuthAlgolia,
            AuthAlgoliaInsights,
            AuthBasic,
            AuthGoogleServiceAccount,
            AuthOAuth,
            Dict[str, str],
        ]
    ]:
        """Returns the dict representation of the actual instance"""
        if self.actual_instance is None:
            return None

        if hasattr(self.actual_instance, "to_dict") and callable(
            self.actual_instance.to_dict  # pyright: ignore
        ):
            return self.actual_instance.to_dict()  # pyright: ignore
        else:
            return self.actual_instance  # pyright: ignore
