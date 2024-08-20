package com.users.model.DTO.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRegisterDTO implements Serializable {
    private String personalId;
    private String name;
    private String personalEmail;
    private byte[] profilePicture;
    private String directorPersonalId;
}