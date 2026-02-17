package com.app.performtrackapi.dtos.Position;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionDto {
    private UUID departmentId;
    private UUID subDepartmentId;
    private String name;
}
