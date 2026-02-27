package com.app.performtrackapi.dtos.User;

import com.app.performtrackapi.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDto {
    private String email;
    private String password;
    private Role role;
    private List<UUID> departmentIds;
    private List<UUID> subDepartmentIds;
}
