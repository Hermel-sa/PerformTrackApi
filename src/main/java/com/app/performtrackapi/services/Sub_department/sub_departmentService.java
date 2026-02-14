package com.app.performtrackapi.services.Sub_department;

import com.app.performtrackapi.dtos.Sub_department.SubDepartmentDto;

import java.util.List;
import java.util.UUID;

public interface sub_departmentService {
    SubDepartmentDto getSubDepartmentById(UUID id);
    SubDepartmentDto getSubDepartmentByDepartmentId(UUID departmentId);
    SubDepartmentDto createSubDepartment(SubDepartmentDto subDepartmentDto);
    SubDepartmentDto updateSubDepartment(UUID id, SubDepartmentDto subDepartmentDto);
    List<SubDepartmentDto> getAllSubDepartments();
    void deleteSubDepartment(UUID id);
}
