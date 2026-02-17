package com.app.performtrackapi.mappers;

import com.app.performtrackapi.dtos.Position.PositionDto;
import com.app.performtrackapi.dtos.Position.PositionResponseDto;
import com.app.performtrackapi.entities.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PositionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "department", ignore = true)
    @Mapping(target = "subDepartment", ignore = true)
    Position toEntity(PositionDto position);

    @Mapping(source = "department.id", target = "departmentId")
    @Mapping(source = "subDepartment.id", target = "subDepartmentId")
    PositionResponseDto toResponseDto(Position position);
}
