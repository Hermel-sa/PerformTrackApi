package com.app.performtrackapi.dtos.User;

import com.app.performtrackapi.dtos.Department.DepartmentResponseDto;
import com.app.performtrackapi.dtos.Sub_department.SubDepartmentResponseDto;
import com.app.performtrackapi.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private UUID id;
    private String email;
    private Role role;
    private List<DepartmentResponseDto> departments;
    private List<SubDepartmentResponseDto> subdepartments;
}
