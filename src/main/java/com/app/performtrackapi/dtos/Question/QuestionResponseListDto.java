package com.app.performtrackapi.dtos.Question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponseListDto {
    private UUID id;
    private String question;
}
