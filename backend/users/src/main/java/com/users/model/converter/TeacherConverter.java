package com.users.model.converter;

import com.users.exceptions.MapException;
import com.users.model.DTO.teacher.TeacherRegisterDTO;
import com.users.model.DTO.teacher.TeacherViewDTO;
import com.users.model.commons.constants.ConstantMessages;
import com.users.model.entities.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherConverter {

    public Teacher teacherRegisterDTOToTeacher(TeacherRegisterDTO teacherRegisterDTO) {
        try {
            return new Teacher(teacherRegisterDTO.getPersonalId(), teacherRegisterDTO.getName(), teacherRegisterDTO.getPersonalEmail(), teacherRegisterDTO.getPassword());
        } catch (MapException e) {
            throw new MapException(ConstantMessages.MAP_ERROR);
        }
    }

    public TeacherViewDTO teacherToteacherViewDTO(Teacher teacher) {
        try {
            return new TeacherViewDTO(teacher.getPersonalId(), teacher.getName(), teacher.getEmail(), teacher.getProfilePictureId(), teacher.getDirector().getPin());
        } catch (MapException e) {
            throw new MapException(ConstantMessages.MAP_ERROR);
        }
    }
}