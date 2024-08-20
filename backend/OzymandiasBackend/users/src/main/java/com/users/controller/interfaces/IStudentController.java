package com.users.controller.interfaces;

import com.users.model.DTO.student.StudentRegisterDTO;
import com.users.model.DTO.student.StudentViewDTO;
import org.springframework.http.ResponseEntity;

public interface IStudentController {
    ResponseEntity<String> login(String email, String password);
    ResponseEntity<StudentViewDTO> create(StudentRegisterDTO studentRegisterDTO);
    ResponseEntity<StudentViewDTO> read(Integer pin);
    ResponseEntity<StudentViewDTO> update(StudentRegisterDTO studentRegisterDTO);
    ResponseEntity<Void> delete(Integer pin);
}