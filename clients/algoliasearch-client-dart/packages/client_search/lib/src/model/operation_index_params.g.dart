// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'operation_index_params.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

OperationIndexParams _$OperationIndexParamsFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'OperationIndexParams',
      json,
      ($checkedConvert) {
        final val = OperationIndexParams(
          operation: $checkedConvert(
              'operation', (v) => $enumDecode(_$OperationTypeEnumMap, v)),
          destination: $checkedConvert('destination', (v) => v as String),
          scope: $checkedConvert(
              'scope',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => $enumDecode(_$ScopeTypeEnumMap, e))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$OperationIndexParamsToJson(
        OperationIndexParams instance) =>
    <String, dynamic>{
      'operation': instance.operation.toJson(),
      'destination': instance.destination,
      if (instance.scope?.map((e) => e.toJson()).toList() case final value?)
        'scope': value,
    };

const _$OperationTypeEnumMap = {
  OperationType.move: 'move',
  OperationType.copy: 'copy',
};

const _$ScopeTypeEnumMap = {
  ScopeType.settings: 'settings',
  ScopeType.synonyms: 'synonyms',
  ScopeType.rules: 'rules',
};
