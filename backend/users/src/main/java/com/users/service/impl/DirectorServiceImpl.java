package com.users.service.impl;

import com.users.model.DTO.LoginDTO;
import com.users.model.DTO.director.DirectorRegisterDTO;
import com.users.model.DTO.director.DirectorViewDTO;
import com.users.model.DTO.teacher.TeacherViewDTO;
import com.users.model.converter.DirectorConverter;
import com.users.model.converter.TeacherConverter;
import com.users.model.entities.Director;
import com.users.model.entities.Teacher;
import com.users.repository.director.DirectorDAO;
import com.users.repository.teacher.TeacherDAO;
import com.users.service.interfaces.IDirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements IDirectorService {

    final DirectorDAO DAO;
    final TeacherDAO teacherDAO;
    final TeacherConverter teacherConverter;
    final DirectorConverter converter;

    @Override
    public String login(LoginDTO loginDTO) {
        return "Login Successfully";
    }

    @Override
    public DirectorViewDTO create(DirectorRegisterDTO directorRegisterDTO) {
        Director director = this.converter.directorRegisterDTOToDirector(directorRegisterDTO);
        this.DAO.save(director);
        return this.converter.directorToDirectorViewDTO(director);
    }

    @Override
    public DirectorViewDTO read(Integer pin) {
        return this.converter.directorToDirectorViewDTO(this.DAO.findByPin(pin));
    }

    @Override
    public DirectorViewDTO update(DirectorRegisterDTO directorRegisterDTO) {
        Director director = this.converter.directorRegisterDTOToDirector(directorRegisterDTO) ;
        this.DAO.update(director);
        return this.converter.directorToDirectorViewDTO(director);
    }

    @Override
    public String deleteTeacher(Integer pin) {
        this.teacherDAO.delete(pin);
        return "Teacher deleted successfully";
    }

    @Override
    public List<TeacherViewDTO> readAllTeacherByDirector(Integer pin) {
        List<Teacher> teachers = this.teacherDAO.findAll();
        return teachers.stream()
                .map(this.teacherConverter::teacherToteacherViewDTO)
                .filter(teacher -> teacher.getDirectorPin().equals(pin))
                .toList();
    }

    @Override
    public Void delete(Integer pin) {
        this.DAO.delete(pin);
        return null;
    }
}