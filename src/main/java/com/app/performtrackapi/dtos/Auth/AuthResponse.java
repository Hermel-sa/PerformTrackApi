package com.app.performtrackapi.dtos.Auth;

import com.app.performtrackapi.dtos.User.UserResponseDto;
import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private UserResponseDto user;
}
