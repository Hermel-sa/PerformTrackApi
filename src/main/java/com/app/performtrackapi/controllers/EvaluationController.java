package com.app.performtrackapi.controllers;

import com.app.performtrackapi.dtos.Evaluation.EvaluationDto;
import com.app.performtrackapi.dtos.Evaluation.EvaluationResponseDto;
import com.app.performtrackapi.services.Evaluation.evaluationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/evaluation")
public class EvaluationController {

    private final evaluationService evaluationService;
    public EvaluationController(evaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @GetMapping("/{positionId}")
    public ResponseEntity<EvaluationResponseDto> getEvaluationByPositionId(@PathVariable UUID positionId){
        return ResponseEntity.ok(evaluationService.getEvaluationByPositionId(positionId));
    }

    @GetMapping("/")
    public ResponseEntity<List<EvaluationResponseDto>> getAllEvaluation(){
        return ResponseEntity.ok(evaluationService.getAllEvaluation());
    }

    @PostMapping("/")
    public ResponseEntity<EvaluationResponseDto> createEvaluation(@RequestBody EvaluationDto evaluationDto){
        return new ResponseEntity<>(evaluationService.createEvaluation(evaluationDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{evaluationId}")
    public ResponseEntity<EvaluationResponseDto> updateEvaluation(@PathVariable UUID evaluationId, @RequestBody EvaluationDto evaluationDto){
        return ResponseEntity.ok(evaluationService.updateEvaluation(evaluationId, evaluationDto));
    }

    @DeleteMapping("/{evaluationId}")
    public ResponseEntity<Void> deleteEvaluation(@PathVariable UUID evaluationId){
        evaluationService.deleteEvaluation(evaluationId);
        return ResponseEntity.noContent().build();
    }
}
