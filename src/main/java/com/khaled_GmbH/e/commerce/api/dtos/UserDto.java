package com.khaled_GmbH.e.commerce.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;
@AllArgsConstructor
@Getter
public class UserDto {
    private UUID id;
    private String username;
    private String email;
}
