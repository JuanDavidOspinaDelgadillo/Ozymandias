package com.users.service.interfaces;

import com.users.model.DTO.director.DirectorRegisterDTO;
import com.users.model.DTO.director.DirectorViewDTO;
import com.users.model.DTO.teacher.TeacherViewDTO;

import java.util.List;

public interface IDirectorService {
    String login(String email, String password);
    DirectorViewDTO create(DirectorRegisterDTO directorRegisterDTO);
    DirectorViewDTO read(Integer pin);
    DirectorViewDTO update(DirectorRegisterDTO directorRegisterDTO);
    Void delete(Integer pin);
    String deleteTeacher(Integer pin);
    List<TeacherViewDTO> readAllTeacherByDirector(Integer pin);
}