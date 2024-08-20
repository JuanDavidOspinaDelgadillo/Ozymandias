package com.users.model.DTO.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentViewDTO implements Serializable {
    private String name;
    private String personalId;
    private String email;
    private String emergencyNumber;
    private String profilePictureId;
}