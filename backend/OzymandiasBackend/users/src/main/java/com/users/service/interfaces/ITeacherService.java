package com.users.service.interfaces;

import com.users.model.DTO.teacher.TeacherRegisterDTO;
import com.users.model.DTO.teacher.TeacherViewDTO;

public interface ITeacherService {
    String login(String email, String password);
    TeacherViewDTO create(TeacherRegisterDTO teacherRegisterDTO);
    TeacherViewDTO read(Integer pin);
    TeacherViewDTO update(TeacherRegisterDTO teacherRegisterDTO);
    Void delete(Integer pin);
}