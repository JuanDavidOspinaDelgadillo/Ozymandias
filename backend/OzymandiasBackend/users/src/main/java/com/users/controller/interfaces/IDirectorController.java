package com.users.controller.interfaces;

import com.users.model.DTO.director.DirectorRegisterDTO;
import com.users.model.DTO.director.DirectorViewDTO;
import com.users.model.DTO.teacher.TeacherViewDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDirectorController {
    ResponseEntity<String> login(String email, String password);
    ResponseEntity<DirectorViewDTO> create(DirectorRegisterDTO directorRegisterDTO);
    ResponseEntity<DirectorViewDTO> read(Integer pin);
    ResponseEntity<DirectorViewDTO> update(DirectorRegisterDTO directorRegisterDTO);
    ResponseEntity<String> deleteTeacher(Integer pin);
    ResponseEntity<List<TeacherViewDTO>> readAllTeachersByDirector(Integer pin)
    ResponseEntity<Void> delete(Integer pin);
}