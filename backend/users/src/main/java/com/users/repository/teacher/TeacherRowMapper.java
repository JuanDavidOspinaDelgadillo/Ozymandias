package com.users.repository.teacher;

import com.users.model.entities.Teacher;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherRowMapper implements RowMapper<Teacher> {
    @Override
    public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
        Teacher teacher = new Teacher();
        teacher.setPin(rs.getInt("teacher_pin"));
        teacher.setPersonalId(rs.getString("teacher_id"));
        teacher.setName(rs.getString("teacher_name"));
        teacher.setPersonalEmail(rs.getString("teacher_personal_email"));
        teacher.setEmail(rs.getString("teacher_email"));
        teacher.setPassword(rs.getString("teacher_password"));
        teacher.setProfilePictureId(rs.getString("teacher_profile_picture_id"));
        return teacher;
    }
}