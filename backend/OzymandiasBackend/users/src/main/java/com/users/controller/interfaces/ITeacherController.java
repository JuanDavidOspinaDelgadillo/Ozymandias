package com.users.controller.interfaces;

import com.users.model.DTO.teacher.TeacherRegisterDTO;
import com.users.model.DTO.teacher.TeacherViewDTO;
import org.springframework.http.ResponseEntity;

public interface ITeacherController {
    ResponseEntity<String> login(String email, String password);
    ResponseEntity<TeacherViewDTO> create(TeacherRegisterDTO teacherRegisterDTO);
    ResponseEntity<TeacherViewDTO> read(Integer pin);
    ResponseEntity<TeacherViewDTO> update(TeacherRegisterDTO teacherRegisterDTO);
    ResponseEntity<Void> delete(Integer pin);
}