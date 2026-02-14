package com.app.performtrackapi.mappers;

import com.app.performtrackapi.dtos.Sub_department.SubDepartmentDto;
import com.app.performtrackapi.entities.Sub_department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubDepartmentMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "department", ignore = true)
    Sub_department toEntity(SubDepartmentDto subDepartmentDto);

    SubDepartmentDto toDto(Sub_department sub_department);
}
