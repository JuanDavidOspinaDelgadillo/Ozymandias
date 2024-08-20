package com.users.model.DTO.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherViewDTO implements Serializable {
    private String personalId;
    private String name;
    private String email;
    private String profilePictureId;
    private Integer directorPin;
}