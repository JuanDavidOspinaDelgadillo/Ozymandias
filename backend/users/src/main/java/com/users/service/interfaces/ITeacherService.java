package com.users.service.interfaces;

import com.users.model.DTO.LoginDTO;
import com.users.model.DTO.teacher.TeacherRegisterDTO;
import com.users.model.DTO.teacher.TeacherViewDTO;

public interface ITeacherService {
    String login(LoginDTO loginDTO);
    TeacherViewDTO create(TeacherRegisterDTO teacherRegisterDTO);
    TeacherViewDTO read(Integer pin);
    TeacherViewDTO update(TeacherRegisterDTO teacherRegisterDTO);
    Void delete(Integer pin);
}