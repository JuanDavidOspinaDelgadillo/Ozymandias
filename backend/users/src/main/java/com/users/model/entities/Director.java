package com.users.model.entities;

import jakarta.persistence.*;
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
    private Integer pin;

    @Column(name = "director_id", unique = true)
    private String personalId;

    @Column(name = "director_name")
    private String name;

    @Column(name = "director_personal_email")
    private String personalEmail;

    @Column(name = "director_email")
    private String email;

    @Column(name = "director_password")
    private String password;

    @Column(name = "director_profile_picture_id")
    private String profilePictureId;

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL)
    private List<Teacher> teachers;

    public Director(String name, String personalId, String personalEmail) {
        this.name = name;
        this.personalId = personalId;
        this.personalEmail = personalEmail;
    }
}