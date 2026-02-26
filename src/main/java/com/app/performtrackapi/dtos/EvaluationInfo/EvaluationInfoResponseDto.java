package com.app.performtrackapi.dtos.EvaluationInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationInfoResponseDto {
    private UUID id;
    private String period;
    private LocalDate date;
    private String edition;
    private String revision;
}
