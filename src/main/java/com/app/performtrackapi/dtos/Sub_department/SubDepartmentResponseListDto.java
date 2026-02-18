package com.app.performtrackapi.dtos.Sub_department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubDepartmentResponseListDto {
    private UUID id;
    private String name;
}
