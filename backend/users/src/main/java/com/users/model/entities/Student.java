package com.users.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    @Id
    @Column(name = "student_pin")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pin;

    @Column(name = "student_id")
    @NotBlank(message = "The personal id couldn't be empty")
    private String personalId;

    @Column(name = "student_name")
    @NotBlank(message = "The name couldn't be empty")
    private String name;

    @Column(name = "student_personal_email")
    @NotBlank(message = "The personal email couldn't be empty")
    @Email(message = "The personal email should have a correct email format")
    private String personalEmail;

    @Column(name = "student_email")
    @Email(message = "The email should have a correct email format")
    private String email;

    @Column(name = "student_password")
    private String password;

    @Column(name = "student_emergency_number")
    @NotBlank(message = "The emergency number couldn't be empty")
    private String emergencyNumber;

    @Column(name = "student_profile_picture_id")
    private String profilePictureId;

    public Student(String name, String personalId, String personalEmail, String emergencyNumber) {
        this.name = name;
        this.personalId = personalId;
        this.personalEmail = personalEmail;
        this.emergencyNumber = emergencyNumber;
    }
}
