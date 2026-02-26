package com.app.performtrackapi.controllers;

import com.app.performtrackapi.dtos.EvaluationInfo.EvaluationInfoDto;
import com.app.performtrackapi.dtos.EvaluationInfo.EvaluationInfoResponseDto;
import com.app.performtrackapi.services.EvaluationInfo.EvaluationInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/evaluation/info")
public class EvaluationInfoController {

    private final EvaluationInfoService evaluationInfoService;

    public EvaluationInfoController(EvaluationInfoService evaluationInfoService){
        this.evaluationInfoService = evaluationInfoService;
    }

    @GetMapping("/")
    public ResponseEntity<EvaluationInfoResponseDto> getEvaluationInfo(){
        return ResponseEntity.ok(evaluationInfoService.getEvaluationInfo());
    }

    @PostMapping("/")
    public ResponseEntity<EvaluationInfoResponseDto> createEvaluationInfo(@RequestBody EvaluationInfoDto evaluationInfoDto){
        return new ResponseEntity<>(evaluationInfoService.createEvaluationInfo(evaluationInfoDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{evaluationInfoId}")
    public ResponseEntity<EvaluationInfoResponseDto> updateEvaluationInfoById(@PathVariable UUID evaluationInfoId, @RequestBody EvaluationInfoDto evaluationInfoDto){
        return ResponseEntity.ok(evaluationInfoService.updateEvaluationInfo(evaluationInfoId, evaluationInfoDto));
    }

}
