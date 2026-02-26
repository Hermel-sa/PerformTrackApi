package com.app.performtrackapi.dtos.EvaluationInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationInfoDto {
    private String period;
    private LocalDate date;
    private String edition;
    private String revision;
}
