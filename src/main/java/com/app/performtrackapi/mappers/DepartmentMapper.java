package com.app.performtrackapi.mappers;

import com.app.performtrackapi.dtos.Department.DepartmentDto;
import com.app.performtrackapi.entities.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    @Mapping(target = "id", ignore = true)
    Department toEntity(DepartmentDto departmentDto);

    DepartmentDto toDto(Department department);
}
