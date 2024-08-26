package com.users.repository.student;

import com.users.model.entities.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setPin(rs.getInt("student_pin"));
        student.setPersonalId(rs.getString("student_id"));
        student.setName(rs.getString("student_name"));
        student.setPersonalEmail(rs.getString("student_personal_email"));
        student.setEmail(rs.getString("student_email"));
        student.setPassword(rs.getString("student_password"));
        student.setEmergencyNumber(rs.getString("student_emergency_number"));
        student.setProfilePictureId(rs.getString("student_profile_picture_id"));
        return student;
    }
}