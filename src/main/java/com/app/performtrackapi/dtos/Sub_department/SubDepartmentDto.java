package com.app.performtrackapi.dtos.Sub_department;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubDepartmentDto {
    @NotBlank(message = "El departamento no puede estar vacío")
    private UUID departmentId;
    private String name;
}
