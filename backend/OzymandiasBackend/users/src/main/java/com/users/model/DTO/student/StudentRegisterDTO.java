package com.users.model.DTO.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRegisterDTO implements Serializable {

    @NotEmpty(message = "Personal ID cannot be empty")
    @Size(max = 50, message = "Personal ID cannot exceed 50 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Personal ID must be alphanumeric")
    private String personalId;

    @NotEmpty(message = "Name cannot be empty")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    @Pattern(regexp = "^[\\p{L} .'-]+$", message = "Name contains invalid characters")
    private String name;

    @Email(message = "Personal email must be a valid email address")
    @NotEmpty(message = "The personal email cannot be empty")
    private String personalEmail;

    @NotEmpty(message = "The emergency number cannot be empty")
    @Pattern(regexp = "^[0-9]+$", message = "The field must contain only numeric characters")
    private String emergencyNumber;

    @NotEmpty(message = "Profile picture cannot be empty")
    private String profilePicture;
}