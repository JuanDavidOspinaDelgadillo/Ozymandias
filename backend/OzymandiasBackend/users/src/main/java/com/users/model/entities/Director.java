package com.users.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "directors")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "director_pin")
    private Integer pin; // Primary key, should be an Integer

    @Column(name = "director_id", unique = true)
    @NotBlank(message = "The personal id couldn't be empty")
    private String personalId; // Unique personal ID

    @Column(name = "director_name")
    @NotBlank(message = "The name couldn't be empty")
    private String name;

    @Column(name = "director_personal_email")
    @NotBlank(message = "The personal email couldn't be empty")
    @Email(message = "The personal email should have a correct email format")
    private String personalEmail;

    @Column(name = "director_email")
    @Email(message = "The email should have a correct email format")
    private String email;

    @Column(name = "director_password")
    @NotBlank(message = "The password couldn't be empty")
    private String password;

    @Column(name = "director_profile_picture_id")
    private String profilePictureId;

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL)
    private List<Teacher> teachers;

    // Constructor for quick initialization
    public Director(String name, String personalId, String personalEmail) {
        this.name = name;
        this.personalId = personalId;
        this.personalEmail = personalEmail;
    }
}