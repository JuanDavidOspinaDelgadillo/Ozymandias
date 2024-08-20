package com.users.service.impl;

import com.users.model.DTO.student.StudentRegisterDTO;
import com.users.model.DTO.student.StudentViewDTO;
import com.users.model.converter.StudentConverter;
import com.users.model.entities.Student;
import com.users.repository.student.StudentDAO;
import com.users.service.interfaces.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {

    final StudentDAO DAO;
    final StudentConverter converter;

    @Override
    public String login(Integer email, String password) {
        return "login successfully";
    }

    @Override
    public StudentViewDTO create(StudentRegisterDTO studentRegisterDTO) {
        Student student = this.converter.studentRegisterDTOToStudent(studentRegisterDTO);
        this.DAO.save(student);
        return this.converter.studentToStudentViewDTO(student);
    }

    @Override
    public StudentViewDTO read(Integer pin) {
        return this.converter.studentToStudentViewDTO(this.DAO.findByPin(pin));
    }

    @Override
    public StudentViewDTO update(StudentRegisterDTO studentRegisterDTO) {
        Student student = this.converter.studentRegisterDTOToStudent(studentRegisterDTO);
        this.DAO.update(student);
        return this.converter.studentToStudentViewDTO(student);
    }

    @Override
    public Void delete(Integer pin) {
        this.DAO.delete(pin);
        return null;
    }
}