package com.app.performtrackapi.services.EvaluationInfo;

import com.app.performtrackapi.dtos.EvaluationInfo.EvaluationInfoDto;
import com.app.performtrackapi.dtos.EvaluationInfo.EvaluationInfoResponseDto;

import java.util.UUID;

public interface EvaluationInfoService {
    EvaluationInfoResponseDto getEvaluationInfo();
    EvaluationInfoResponseDto createEvaluationInfo(EvaluationInfoDto evaluationInfoDto);
    EvaluationInfoResponseDto updateEvaluationInfo(UUID id, EvaluationInfoDto evaluationInfoDto);
}
