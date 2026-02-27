package com.app.performtrackapi.dtos.User;

import com.app.performtrackapi.entities.Role;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {
    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El formato del email es inválido")
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@hermel-sa.com$",
            message = "El email debe ser de la empresa(hermel-sa.com)"
    )
    String email;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    String password;

    @NotNull(message = "El rol es obligatorio")
    Role role;

    private List<UUID> departmentIds;

    private List<UUID> subDepartmentIds;
}
