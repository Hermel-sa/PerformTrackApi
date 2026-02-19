package com.app.performtrackapi.mappers;

import com.app.performtrackapi.dtos.Evaluation.EvaluationDto;
import com.app.performtrackapi.dtos.Evaluation.EvaluationResponseDto;
import com.app.performtrackapi.entities.Evaluation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { CategoryMapper.class })
public interface EvaluationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "position", ignore = true)
    @Mapping(target = "categories", ignore = true)
    Evaluation toEntity(EvaluationDto evaluationDto);

    @Mapping(source = "position.id", target = "positionId")
    EvaluationResponseDto toResponseDto(Evaluation evaluation);
}
