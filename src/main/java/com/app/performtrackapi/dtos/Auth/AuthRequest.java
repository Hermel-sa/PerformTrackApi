package com.app.performtrackapi.dtos.Auth;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
