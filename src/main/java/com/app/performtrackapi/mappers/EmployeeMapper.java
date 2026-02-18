package com.app.performtrackapi.mappers;

import com.app.performtrackapi.dtos.Employee.EmployeeDto;
import com.app.performtrackapi.dtos.Employee.EmployeeResponseDto;
import com.app.performtrackapi.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "position", ignore = true)
    @Mapping(target = "user", ignore = true)
    Employee toEntity(EmployeeDto employeeDto);

    @Mapping(source = "position.id", target = "positionId")
    @Mapping(source = "user.id", target = "userId")
    EmployeeResponseDto toResponseDto(Employee employee);
}
