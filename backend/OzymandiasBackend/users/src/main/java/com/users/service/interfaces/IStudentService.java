package com.users.service.interfaces;

import com.users.model.DTO.LoginDTO;
import com.users.model.DTO.student.StudentRegisterDTO;
import com.users.model.DTO.student.StudentViewDTO;

public interface IStudentService {
    String login(LoginDTO loginDTO);
    StudentViewDTO create(StudentRegisterDTO studentRegisterDTO);
    StudentViewDTO read(Integer pin);
    StudentViewDTO update(StudentRegisterDTO studentRegisterDTO);
    Void delete(Integer pin);
}