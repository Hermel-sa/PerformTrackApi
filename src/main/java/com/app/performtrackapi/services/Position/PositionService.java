package com.app.performtrackapi.services.Position;

import com.app.performtrackapi.dtos.Position.PositionDto;
import com.app.performtrackapi.dtos.Position.PositionResponseDto;

import java.util.List;
import java.util.UUID;

public interface PositionService {
    PositionResponseDto getPositionById(UUID id);

    List<PositionResponseDto> getAllPosition();

    PositionResponseDto createPosition(PositionDto positionDto);

    PositionResponseDto updatePosition(UUID id, PositionDto positionDto);

    void deletePosition(UUID id);
}
