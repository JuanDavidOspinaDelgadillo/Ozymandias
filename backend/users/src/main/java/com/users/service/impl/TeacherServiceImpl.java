package com.users.service.impl;

import com.users.model.DTO.LoginDTO;
import com.users.model.DTO.teacher.TeacherRegisterDTO;
import com.users.model.DTO.teacher.TeacherViewDTO;
import com.users.model.converter.TeacherConverter;
import com.users.model.entities.Teacher;
import com.users.repository.teacher.TeacherDAO;
import com.users.service.interfaces.ITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements ITeacherService {

    final TeacherConverter converter;
    final TeacherDAO DAO;


    @Override
    public String login(LoginDTO loginDTO) {
        return "Login Successfully";
    }

    @Override
    public TeacherViewDTO create(TeacherRegisterDTO teacherRegisterDTO) {
        Teacher teacher = this.converter.teacherRegisterDTOToTeacher(teacherRegisterDTO);
        this.DAO.save(teacher);
        return this.converter.teacherToteacherViewDTO(teacher);
    }

    @Override
    public TeacherViewDTO read(Integer pin) {
        return this.converter.teacherToteacherViewDTO(this.DAO.findByPin(pin));
    }

    @Override
    public TeacherViewDTO update(TeacherRegisterDTO teacherRegisterDTO) {
        Teacher teacher = this.converter.teacherRegisterDTOToTeacher(teacherRegisterDTO);
        this.DAO.update(teacher);
        return this.converter.teacherToteacherViewDTO(teacher);
    }

    @Override
    public Void delete(Integer pin) {
        this.DAO.delete(pin);
        return null;
    }
}