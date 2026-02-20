package com.app.performtrackapi.dtos.Category;

import com.app.performtrackapi.dtos.Question.QuestionResponseListDto;
import com.app.performtrackapi.dtos.Question.QuestionWithAnswerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryWithProgressDto {
    private UUID id;
    private String name;
    private Integer weight;
    private Integer order_index;
    private List<QuestionWithAnswerDto> questions;
}
