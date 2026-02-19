package com.app.performtrackapi.services.Question;

import com.app.performtrackapi.dtos.Question.QuestionDto;
import com.app.performtrackapi.dtos.Question.QuestionResponseDto;

import java.util.UUID;

public interface questionService {
    QuestionResponseDto getQuestionById(UUID id);
    QuestionResponseDto createQuestion(QuestionDto questionDto);
    QuestionResponseDto updateQuestion(UUID id, QuestionDto questionDto);
    void deleteQuestion(UUID id);
}
