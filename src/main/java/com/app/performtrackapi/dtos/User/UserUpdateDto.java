package com.app.performtrackapi.dtos.User;

import com.app.performtrackapi.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDto {
    private String email;
    private String password;
    private Role role;
}
