package com.app.performtrackapi.services.Department;

import com.app.performtrackapi.dtos.Department.DepartmentDto;

import java.util.List;
import java.util.UUID;

public interface departmentService {
    DepartmentDto getDepartmentById(UUID id);
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto updateDepartment(UUID id, DepartmentDto departmentDto);
    List<DepartmentDto> getAllDepartments();
    void deleteDepartment(UUID id);
}
