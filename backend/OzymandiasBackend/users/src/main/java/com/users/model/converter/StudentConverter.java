package com.users.model.converter;

import com.users.exceptions.MapException;
import com.users.model.commons.constants.ConstantMessages;
import com.users.model.DTO.student.StudentRegisterDTO;
import com.users.model.DTO.student.StudentViewDTO;
import com.users.model.entities.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {

    public Student studentRegisterDTOToStudent(StudentRegisterDTO studentRegisterDTO) {
        try {
            return new Student(studentRegisterDTO.getName(), studentRegisterDTO.getPersonalId(), studentRegisterDTO.getPersonalEmail(), studentRegisterDTO.getEmergencyNumber());
        } catch (MapException e) {
            throw new MapException(ConstantMessages.MAP_ERROR);
        }
    }

    public StudentViewDTO studentToStudentViewDTO(Student student) {
        try {
            return new StudentViewDTO(student.getName(), student.getPersonalId(), student.getEmail(), student.getEmergencyNumber(), student.getProfilePictureId());
        } catch (MapException e) {
            throw new MapException(ConstantMessages.MAP_ERROR);
        }
    }
}