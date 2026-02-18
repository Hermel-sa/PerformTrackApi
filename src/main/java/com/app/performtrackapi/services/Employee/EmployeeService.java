package com.app.performtrackapi.services.Employee;

import com.app.performtrackapi.dtos.Employee.EmployeeDto;
import com.app.performtrackapi.dtos.Employee.EmployeeResponseDto;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    EmployeeResponseDto getEmployeeById(UUID id);
    EmployeeResponseDto getEmployeeByPositionId(UUID positionId);
    List<EmployeeResponseDto> getAllEmployee();
    EmployeeResponseDto createEmployee(EmployeeDto employeeDto);
    EmployeeResponseDto updateEmployee(UUID id, EmployeeDto employeeDto);
    void deleteEmployee(UUID id);
}
