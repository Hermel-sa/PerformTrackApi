package com.app.performtrackapi.services.EvaluationInfo;

import com.app.performtrackapi.dtos.EvaluationInfo.EvaluationInfoDto;
import com.app.performtrackapi.dtos.EvaluationInfo.EvaluationInfoResponseDto;
import com.app.performtrackapi.entities.EvaluationInfo;
import com.app.performtrackapi.mappers.EvaluationInfoMapper;
import com.app.performtrackapi.repositories.EvaluationInfoRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EvaluationInfoServiceImpl implements EvaluationInfoService{

    private final EvaluationInfoRepository evaluationInfoRepository;
    private final EvaluationInfoMapper evaluationInfoMapper;

    public EvaluationInfoServiceImpl(EvaluationInfoRepository evaluationInfoRepository, EvaluationInfoMapper evaluationInfoMapper){
        this.evaluationInfoRepository = evaluationInfoRepository;
        this.evaluationInfoMapper = evaluationInfoMapper;
    }

    @Override
    public EvaluationInfoResponseDto getEvaluationInfo() {

        EvaluationInfo evaluationInfo = evaluationInfoRepository.findAll().getFirst();

        return evaluationInfoMapper.toResponseDto(evaluationInfo);
    }

    @Override
    public EvaluationInfoResponseDto createEvaluationInfo(EvaluationInfoDto evaluationInfoDto) {

        EvaluationInfo evaluationInfo = evaluationInfoMapper.toEntity(evaluationInfoDto);
        evaluationInfo.setPeriod(evaluationInfo.getPeriod());
        evaluationInfo.setDate(evaluationInfo.getDate());
        evaluationInfo.setEdition(evaluationInfo.getEdition());
        evaluationInfo.setRevision(evaluationInfo.getRevision());

        EvaluationInfo savedEvaluationInfo = evaluationInfoRepository.save(evaluationInfo);

        return evaluationInfoMapper.toResponseDto(savedEvaluationInfo);
    }

    @Override
    public EvaluationInfoResponseDto updateEvaluationInfo(UUID id, EvaluationInfoDto evaluationInfoDto) {

        EvaluationInfo evaluationInfo = evaluationInfoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Information not found"));

        if (evaluationInfoDto.getPeriod() != null) {
            evaluationInfo.setPeriod(evaluationInfoDto.getPeriod());
        }

        if (evaluationInfoDto.getDate() != null) {
            evaluationInfo.setDate(evaluationInfoDto.getDate());
        }

        if (evaluationInfoDto.getRevision() != null) {
            evaluationInfo.setRevision(evaluationInfoDto.getRevision());
        }

        if (evaluationInfoDto.getEdition() != null) {
            evaluationInfo.setEdition(evaluationInfoDto.getEdition());
        }

        EvaluationInfo updateEvaluationInfo = evaluationInfoRepository.save(evaluationInfo);

        return evaluationInfoMapper.toResponseDto(updateEvaluationInfo);
    }
}
