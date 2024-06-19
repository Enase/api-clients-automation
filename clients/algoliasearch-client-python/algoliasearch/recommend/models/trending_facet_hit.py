# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from typing import Annotated, Any, Dict, Self, Union

from pydantic import BaseModel, ConfigDict, Field, StrictStr


class TrendingFacetHit(BaseModel):
    """
    Trending facet hit.
    """

    score: Union[
        Annotated[float, Field(le=100, strict=True, ge=0)],
        Annotated[int, Field(le=100, strict=True, ge=0)],
    ] = Field(description="Recommendation score.", alias="_score")
    facet_name: StrictStr = Field(
        description="Facet attribute. To be used in combination with `facetValue`. If specified, only recommendations matching the facet filter will be returned. ",
        alias="facetName",
    )
    facet_value: StrictStr = Field(
        description="Facet value. To be used in combination with `facetName`. If specified, only recommendations matching the facet filter will be returned. ",
        alias="facetValue",
    )

    model_config = ConfigDict(
        use_enum_values=True, populate_by_name=True, validate_assignment=True
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of TrendingFacetHit from a JSON string"""
        return cls.from_dict(loads(json_str))

    def to_dict(self) -> Dict[str, Any]:
        """Return the dictionary representation of the model using alias.

        This has the following differences from calling pydantic's
        `self.model_dump(by_alias=True)`:

        * `None` is only added to the output dict for nullable fields that
          were set at model initialization. Other fields with value `None`
          are ignored.
        """
        _dict = self.model_dump(
            by_alias=True,
            exclude={},
            exclude_none=True,
        )
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of TrendingFacetHit from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "_score": obj.get("_score"),
                "facetName": obj.get("facetName"),
                "facetValue": obj.get("facetValue"),
            }
        )
        return _obj
