package com.app.performtrackapi.dtos.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponseDto {
    private UUID id;
    private String name;
}
