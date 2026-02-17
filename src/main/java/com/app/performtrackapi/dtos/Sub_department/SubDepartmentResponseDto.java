package com.app.performtrackapi.dtos.Sub_department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubDepartmentResponseDto {
    private UUID id;
    private UUID departmentId;
    private String name;
}
