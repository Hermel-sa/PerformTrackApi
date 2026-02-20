package com.app.performtrackapi.dtos.Question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionWithAnswerDto {
    private UUID questionId;
    private String question;
    private Integer answer;
}
