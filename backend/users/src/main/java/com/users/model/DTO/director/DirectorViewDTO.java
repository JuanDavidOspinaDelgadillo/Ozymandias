package com.users.model.DTO.director;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorViewDTO implements Serializable {
    private String name;
    private String personalId;
    private String email;
    private String profilePictureId;
}
