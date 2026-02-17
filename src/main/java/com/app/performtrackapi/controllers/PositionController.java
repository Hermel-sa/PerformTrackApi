package com.app.performtrackapi.controllers;

import com.app.performtrackapi.dtos.Position.PositionDto;
import com.app.performtrackapi.dtos.Position.PositionResponseDto;
import com.app.performtrackapi.services.Position.PositionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/positions")
public class PositionController {

    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/")
    public ResponseEntity<List<PositionResponseDto>> getAllPosition() {

        List<PositionResponseDto> positionDto = positionService.getAllPosition();

        return ResponseEntity.ok(positionDto);
    }

    @GetMapping("/{positionId}")
    public ResponseEntity<PositionResponseDto> getPositionById(@PathVariable UUID positionId) {
        return ResponseEntity.ok(positionService.getPositionById(positionId));
    }

    @PostMapping("/")
    public ResponseEntity<PositionResponseDto> createPosition(@RequestBody PositionDto positionDto) {
        return new ResponseEntity<>(positionService.createPosition(positionDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{positionId}")
    public ResponseEntity<PositionResponseDto> updatePosition(@PathVariable UUID positionId,
            @RequestBody PositionDto positionDto) {
        return ResponseEntity.ok(positionService.updatePosition(positionId, positionDto));
    }

    @DeleteMapping("/{positionId}")
    public ResponseEntity<Void> deletePosition(@PathVariable UUID positionId) {
        positionService.deletePosition(positionId);
        return ResponseEntity.noContent().build();
    }

}
