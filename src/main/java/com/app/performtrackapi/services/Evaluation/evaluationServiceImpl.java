package com.app.performtrackapi.services.Evaluation;

import com.app.performtrackapi.dtos.Evaluation.EvaluationDto;
import com.app.performtrackapi.dtos.Evaluation.EvaluationResponseDto;
import com.app.performtrackapi.entities.Evaluation;
import com.app.performtrackapi.entities.Position;
import com.app.performtrackapi.exceptions.ResourceNotFound;
import com.app.performtrackapi.mappers.EvaluationMapper;
import com.app.performtrackapi.repositories.EvaluationRepository;
import com.app.performtrackapi.repositories.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class evaluationServiceImpl implements evaluationService{

    private final EvaluationRepository evaluationRepository;
    private final EvaluationMapper evaluationMapper;
    private final PositionRepository positionRepository;

    public evaluationServiceImpl(EvaluationRepository evaluationRepository, EvaluationMapper evaluationMapper, PositionRepository positionRepository) {
        this.evaluationRepository = evaluationRepository;
        this.evaluationMapper = evaluationMapper;
        this.positionRepository = positionRepository;
    }

    @Override
    public EvaluationResponseDto createEvaluation(EvaluationDto evaluationDto) {

        Position position = positionRepository.findById(evaluationDto.getPositionId())
                .orElseThrow(() -> new ResourceNotFound("Position not found"));

        Evaluation evaluation = evaluationMapper.toEntity(evaluationDto);
        evaluation.setPosition(position);

        Evaluation savedEvaluation = evaluationRepository.save(evaluation);

        return evaluationMapper.toResponseDto(savedEvaluation);
    }

    @Override
    public EvaluationResponseDto getEvaluationByPositionId(UUID positionId) {
        if (!positionRepository.existsById(positionId)){
            throw new RuntimeException("Position not found");
        }

        Evaluation evaluation = evaluationRepository.findByPositionId(positionId);

        return evaluationMapper.toResponseDto(evaluation);
    }

    @Override
    public List<EvaluationResponseDto> getAllEvaluation() {
        return evaluationRepository.findAll().stream().map(evaluationMapper::toResponseDto).toList();
    }

    @Override
    public EvaluationResponseDto updateEvaluation(UUID id, EvaluationDto evaluationDto) {

        Evaluation evaluation = evaluationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Evaluation not found")
                );

        if (evaluationDto.getPositionId() != null) {
            Position position = positionRepository.findById(evaluationDto.getPositionId())
                    .orElseThrow(() -> new ResourceNotFound("Position not found"));
            evaluation.setPosition(position);
        }

        Evaluation updatedEvaluation = evaluationRepository.save(evaluation);

        return evaluationMapper.toResponseDto(updatedEvaluation)    ;
    }

    @Override
    public void deleteEvaluation(UUID id) {
        if (!evaluationRepository.existsById(id)){
            throw new RuntimeException("Evaluation not found");
        }

        evaluationRepository.deleteById(id);
    }
}
