package com.app.performtrackapi.services.User;

import com.app.performtrackapi.dtos.User.UserCreateDto;
import com.app.performtrackapi.dtos.User.UserResponseDto;
import com.app.performtrackapi.dtos.User.UserUpdateDto;
import com.app.performtrackapi.entities.Department;
import com.app.performtrackapi.entities.Role;
import com.app.performtrackapi.entities.Sub_department;
import com.app.performtrackapi.entities.User;
import com.app.performtrackapi.mappers.UserMapper;
import com.app.performtrackapi.repositories.DepartmentRepository;
import com.app.performtrackapi.repositories.SubDepartmentRepository;
import com.app.performtrackapi.repositories.UserRepository;
import com.app.performtrackapi.exceptions.BadRequestException;
import com.app.performtrackapi.exceptions.ResourceNotFound;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final DepartmentRepository departmentRepository;
    private final SubDepartmentRepository subDepartmentRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           UserMapper userMapper, DepartmentRepository departmentRepository,
                           SubDepartmentRepository subDepartmentRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.departmentRepository = departmentRepository;
        this.subDepartmentRepository = subDepartmentRepository;
    }

    @Override
    public UserResponseDto createUser(UserCreateDto userCreateDto) {

        if (userRepository.existsByEmail(userCreateDto.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        User user = userMapper.toEntity(userCreateDto);
        user.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));

        if (Role.evaluator.equals(userCreateDto.getRole())) {
            user.setDepartments(resolveDepartments(userCreateDto.getDepartmentIds()));
            user.setSubDepartments(resolveSubDepartments(userCreateDto.getSubDepartmentIds()));
        }

        User savedUser = userRepository.save(user);
        return userMapper.toResponseDto(savedUser);
    }

    @Override
    public UserResponseDto updateUser(UUID id, UserUpdateDto userUpdateDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User not found"));

        if (userUpdateDto.getEmail() != null) {
            user.setEmail(userUpdateDto.getEmail());
        }
        if (userUpdateDto.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(userUpdateDto.getPassword()));
        }
        if (userUpdateDto.getRole() != null) {
            user.setRole(userUpdateDto.getRole());
        }

        // Always sync departments/subDepartments when updating
        // If role is EVALUADOR, use provided lists; otherwise clear them
        Role effectiveRole = userUpdateDto.getRole() != null ? userUpdateDto.getRole() : user.getRole();
        if (Role.evaluator.equals(effectiveRole)) {
            if (userUpdateDto.getDepartmentIds() != null) {
                user.setDepartments(resolveDepartments(userUpdateDto.getDepartmentIds()));
            }
            if (userUpdateDto.getSubDepartmentIds() != null) {
                user.setSubDepartments(resolveSubDepartments(userUpdateDto.getSubDepartmentIds()));
            }
        } else {
            // If role changed away from EVALUADOR, clear the department assignments
            if (userUpdateDto.getRole() != null) {
                user.setDepartments(new ArrayList<>());
                user.setSubDepartments(new ArrayList<>());
            }
        }

        User updatedUser = userRepository.save(user);
        return userMapper.toResponseDto(updatedUser);
    }

    @Override
    public void deleteUser(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFound("User not found");
        }
        userRepository.deleteById(id);
    }

    @Override
    public UserResponseDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFound("User not found with email: " + email));
        return userMapper.toResponseDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUser() {
        return userRepository.findAll().stream().map(userMapper::toResponseDto).toList();
    }

    // --- Helpers ---

    private List<Department> resolveDepartments(List<UUID> ids) {
        if (ids == null || ids.isEmpty()) return new ArrayList<>();
        return departmentRepository.findAllById(ids);
    }

    private List<Sub_department> resolveSubDepartments(List<UUID> ids) {
        if (ids == null || ids.isEmpty()) return new ArrayList<>();
        return subDepartmentRepository.findAllById(ids);
    }
}
