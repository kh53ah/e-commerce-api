package com.khaled_GmbH.e.commerce.api.mappers;

import com.khaled_GmbH.e.commerce.api.controllers.UpdateUserRequest;
import com.khaled_GmbH.e.commerce.api.dtos.RegisterUserRequest;
import com.khaled_GmbH.e.commerce.api.dtos.UserDto;
import com.khaled_GmbH.e.commerce.api.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    @Mapping(source = "name", target = "username")
    User toEntity(RegisterUserRequest request); //to create entities from the incoming CREATE requests
    void update(UpdateUserRequest request, @MappingTarget User user);
}
