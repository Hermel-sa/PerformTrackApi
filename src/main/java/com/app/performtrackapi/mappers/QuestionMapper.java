package com.app.performtrackapi.mappers;

import com.app.performtrackapi.dtos.Question.QuestionDto;
import com.app.performtrackapi.dtos.Question.QuestionResponseDto;
import com.app.performtrackapi.entities.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    Question toEntity(QuestionDto question);

    @Mapping(source = "category.id", target = "categoryId")
    QuestionResponseDto toResponseDto(Question question);
}
