# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from sys import version_info
from typing import Any, Dict, Optional

from pydantic import BaseModel, ConfigDict

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


from algoliasearch.recommend.models.fbt_model import FbtModel
from algoliasearch.recommend.models.recommend_search_params import RecommendSearchParams

_ALIASES = {
    "index_name": "indexName",
    "threshold": "threshold",
    "max_recommendations": "maxRecommendations",
    "query_parameters": "queryParameters",
    "model": "model",
    "object_id": "objectID",
}


def _alias_generator(name: str) -> str:
    return _ALIASES.get(name, name)


class BoughtTogetherQuery(BaseModel):
    """
    BoughtTogetherQuery
    """

    index_name: str
    """ Index name (case-sensitive). """
    threshold: float
    """ Minimum score a recommendation must have to be included in the response. """
    max_recommendations: Optional[int] = None
    """ Maximum number of recommendations to retrieve. By default, all recommendations are returned and no fallback request is made. Depending on the available recommendations and the other request parameters, the actual number of recommendations may be lower than this value.  """
    query_parameters: Optional[RecommendSearchParams] = None
    model: FbtModel
    object_id: str
    """ Unique record identifier. """

    model_config = ConfigDict(
        strict=False,
        use_enum_values=True,
        populate_by_name=True,
        validate_assignment=True,
        protected_namespaces=(),
        alias_generator=_alias_generator,
        extra="allow",
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Optional[Self]:
        """Create an instance of BoughtTogetherQuery from a JSON string"""
        return cls.from_dict(loads(json_str))

    def to_dict(self) -> Dict[str, Any]:
        """Return the dictionary representation of the model using alias."""
        return self.model_dump(
            by_alias=True,
            exclude_none=True,
            exclude_unset=True,
        )

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of BoughtTogetherQuery from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        obj["queryParameters"] = (
            RecommendSearchParams.from_dict(obj["queryParameters"])
            if obj.get("queryParameters") is not None
            else None
        )
        obj["model"] = obj.get("model")

        return cls.model_validate(obj)
