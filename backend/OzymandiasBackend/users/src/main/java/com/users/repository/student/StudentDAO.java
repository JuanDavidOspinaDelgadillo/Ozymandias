package com.users.repository.student;

import com.users.exceptions.EntityAlreadyExistException;
import com.users.exceptions.EntityDoesntExistException;
import com.users.model.commons.constants.ConstantMessages;
import com.users.model.entities.Student;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class StudentDAO {

    final JdbcTemplate jdbcTemplate;

    @Transactional
    public void save(Student student) {
        String checkSql = "SELECT COUNT(*) FROM students WHERE student_pin = ?";
        int count = Optional.ofNullable(this.jdbcTemplate.queryForObject(checkSql, new Object[]{student.getPin()}, Integer.class)).orElse(0);
        if (count > 0)
            throw new EntityAlreadyExistException(ConstantMessages.ENTITY_ALREADY_EXISTS);
        String sql = "INSERT INTO students (student_id, student_name, student_personal_email, student_email, student_password, student_emergency_number, student_profile_picture_id) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING student_pin";
        Integer generatedPin = this.jdbcTemplate.queryForObject(sql, new Object[]{
                student.getPersonalId(), student.getName(), student.getPersonalEmail(), student.getEmail(),
                student.getPassword(), student.getEmergencyNumber(), student.getProfilePictureId()
        }, Integer.class);
        student.setPin(generatedPin);
    }

    @Transactional
    public int update(Student student) {
        if (!existsByPin(student.getPin()))
            throw new EntityDoesntExistException(ConstantMessages.ENTITY_NOT_FOUND);
        String sql = "UPDATE students SET student_id = ?, student_name = ?, student_personal_email = ?, student_email = ?, student_password = ?, student_emergency_number = ?, student_profile_picture_id = ? WHERE student_pin = ?";
        return this.jdbcTemplate.update(sql, student.getPersonalId(), student.getName(), student.getPersonalEmail(), student.getEmail(), student.getPassword(), student.getEmergencyNumber(), student.getProfilePictureId(), student.getPin());
    }

    public Student findByPin(int pin) {
        String sql = "SELECT * FROM students WHERE student_pin = ?";
        try {
            return this.jdbcTemplate.queryForObject(sql, new Object[]{pin}, new StudentRowMapper());
        } catch (EntityDoesntExistException e) {
            throw new EntityDoesntExistException(ConstantMessages.ENTITY_NOT_FOUND);
        }
    }

    public List<Student> findAll() {
        String sql = "SELECT * FROM students";
        List<Student> students = this.jdbcTemplate.query(sql, new StudentRowMapper());
        if (students.isEmpty())
            throw new EntityDoesntExistException(ConstantMessages.NO_ENTITIES_REGISTERED);
        return students;
    }

    @Transactional
    public int delete(int pin) {
        if (!existsByPin(pin))
            throw new EntityDoesntExistException(ConstantMessages.ENTITY_NOT_FOUND);
        String sql = "DELETE FROM students WHERE student_pin = ?";
        return this.jdbcTemplate.update(sql, pin);
    }

    private boolean existsByPin(int pin) {
        String sql = "SELECT COUNT(*) FROM students WHERE student_pin = ?";
        Integer count = this.jdbcTemplate.queryForObject(sql, Integer.class, pin);
        return count != null && count > 0;
    }
}