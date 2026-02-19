package com.app.performtrackapi.dtos.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private String name;
    private Integer weight;
    private Integer order_index;
    private UUID evaluationId;
}
