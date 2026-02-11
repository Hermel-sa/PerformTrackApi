package com.app.performtrackapi.controllers.User;

import com.app.performtrackapi.dtos.User.UserCreateDto;
import com.app.performtrackapi.dtos.User.UserResponseDto;
import com.app.performtrackapi.dtos.User.UserUpdateDto;
import com.app.performtrackapi.services.User.userService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final userService userService;

    public UserController(userService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<UserResponseDto> userCreate(@Valid @RequestBody UserCreateDto userCreateDto) {
        return new ResponseEntity<>(userService.createUser(userCreateDto), HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<UserResponseDto> userUpdate(@PathVariable UUID id, @RequestBody UserUpdateDto userUpdateDto) {
        return ResponseEntity.ok(userService.updateUser(id, userUpdateDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> userDelete(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
