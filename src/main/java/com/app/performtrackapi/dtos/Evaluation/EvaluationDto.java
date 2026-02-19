package com.app.performtrackapi.dtos.Evaluation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationDto {
    private UUID positionId;
}
