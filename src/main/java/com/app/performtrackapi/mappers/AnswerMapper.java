package com.app.performtrackapi.mappers;

import com.app.performtrackapi.dtos.Answer.AnswerDto;
import com.app.performtrackapi.dtos.Answer.AnswerResponseDto;
import com.app.performtrackapi.entities.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "question", ignore = true)
    @Mapping(target = "record", ignore = true)
    Answer toEntity(AnswerDto answer);

    @Mapping(source = "question.id", target = "questionId")
    @Mapping(source = "record.id", target = "recordId")
    AnswerResponseDto toRespondDto(Answer answer);
}
