package com.app.performtrackapi.dtos.Evaluation;

import com.app.performtrackapi.dtos.Category.CategoryWithProgressDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationWithProgress {
    private UUID id;
    private UUID positionId;
    private List<CategoryWithProgressDto> categories;
}
