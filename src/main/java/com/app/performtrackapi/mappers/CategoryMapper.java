package com.app.performtrackapi.mappers;

import com.app.performtrackapi.dtos.Category.CategoryDto;
import com.app.performtrackapi.dtos.Category.CategoryResponseDto;
import com.app.performtrackapi.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { QuestionMapper.class })
public interface CategoryMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "evaluation", ignore = true)
    @Mapping(target = "questions", ignore = true)
    Category toEntity(CategoryDto category);

    @Mapping(source = "evaluation.id", target = "evaluationId")
    CategoryResponseDto toResponseDto(Category category);
}
