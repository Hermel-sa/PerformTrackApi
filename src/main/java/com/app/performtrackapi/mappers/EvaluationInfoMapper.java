package com.app.performtrackapi.mappers;

import com.app.performtrackapi.dtos.EvaluationInfo.EvaluationInfoDto;
import com.app.performtrackapi.dtos.EvaluationInfo.EvaluationInfoResponseDto;
import com.app.performtrackapi.entities.EvaluationInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EvaluationInfoMapper {

    @Mapping(target = "id", ignore = true)
    EvaluationInfo toEntity(EvaluationInfoDto evaluationInfoDto);

    EvaluationInfoResponseDto toResponseDto(EvaluationInfo evaluationInfo);
}
