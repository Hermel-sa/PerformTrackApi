package com.app.performtrackapi.mappers;

import com.app.performtrackapi.dtos.User.UserCreateDto;
import com.app.performtrackapi.dtos.User.UserResponseDto;
import com.app.performtrackapi.dtos.User.UserUpdateDto;
import com.app.performtrackapi.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "departments", ignore = true)
    @Mapping(target = "subDepartments", ignore = true)
    User toEntity(UserCreateDto userCreateDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "departments", ignore = true)
    @Mapping(target = "subDepartments", ignore = true)
    User toEntity(UserUpdateDto userUpdateDto);

    @Mapping(target = "subdepartments", source = "subDepartments")
    UserResponseDto toResponseDto(User user);
}
