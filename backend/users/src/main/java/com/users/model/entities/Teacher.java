package com.users.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "teachers")
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_pin")
    private Integer pin; // Primary key, should be an Integer

    @Column(name = "teacher_id")
    @NotBlank(message = "The personal id couldn't be empty")
    private String personalId;

    @Column(name = "teacher_name")
    @NotBlank(message = "The name couldn't be empty")
    private String name;

    @Column(name = "teacher_personal_email")
    @NotBlank(message = "The personal email couldn't be empty")
    @Email(message = "The personal email should have a correct email format")
    private String personalEmail;

    @Column(name = "teacher_email")
    @Email(message = "The email should have a correct email format")
    private String email;

    @Column(name = "teacher_password")
    private String password;

    @Column(name = "teacher_profile_picture_id")
    private String profilePictureId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_pin", referencedColumnName = "director_pin")
    private Director director;

    // Constructor for quick initialization
    public Teacher(String personalId, String name, String personalEmail, String password) {
        this.personalId = personalId;
        this.name = name;
        this.personalEmail = personalEmail;
    }
}