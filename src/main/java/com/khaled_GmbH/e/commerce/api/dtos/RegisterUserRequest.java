package com.khaled_GmbH.e.commerce.api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserRequest {
    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name must be less than 255 characters")
    public String name;
    @NotBlank(message = "Name is required")
    @Email(message = "Email must be valid")
    public String email;
    @NotBlank(message = "Name is required")
    @Size(min = 6, max = 25, message = "Password must be between 6 and 25 characters")
    private String password;
}
