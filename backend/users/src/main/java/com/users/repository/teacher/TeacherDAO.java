package com.users.repository.teacher;

import com.users.exceptions.EntityAlreadyExistException;
import com.users.exceptions.EntityDoesntExistException;
import com.users.model.commons.constants.ConstantMessages;
import com.users.model.entities.Teacher;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TeacherDAO {

    final JdbcTemplate jdbcTemplate;

    @Transactional
    public void save(Teacher teacher) {
        String checkSql = "SELECT COUNT(*) FROM teachers WHERE teacher_pin = ?";
        int count = Optional.ofNullable(this.jdbcTemplate.queryForObject(checkSql, new Object[]{teacher.getPin()}, Integer.class)).orElse(0);
        if (count > 0)
            throw new EntityAlreadyExistException(ConstantMessages.ENTITY_ALREADY_EXISTS);
        String sql = "INSERT INTO teachers (teacher_id, teacher_name, teacher_personal_email, teacher_email, teacher_password, teacher_profile_picture_id, director_pin) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING student_pin";
        this.jdbcTemplate.update(sql, teacher.getPersonalId(), teacher.getName(), teacher.getPersonalEmail(), teacher.getEmail(), teacher.getPassword(), teacher.getProfilePictureId(), teacher.getDirector() != null ? teacher.getDirector().getPin() : null);
        Integer generatedPin = this.jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        teacher.setPin(generatedPin);
    }

    @Transactional
    public int update(Teacher teacher) {
        if (!existsByPin(teacher.getPin()))
            throw new EntityDoesntExistException(ConstantMessages.ENTITY_NOT_FOUND);
        String sql = "UPDATE teachers SET teacher_id = ?, teacher_name = ?, teacher_personal_email = ?, teacher_email = ?, teacher_password = ?, teacher_profile_picture_id = ?, director_pin = ? WHERE teacher_pin = ?";
        return this.jdbcTemplate.update(sql, teacher.getPersonalId(), teacher.getName(), teacher.getPersonalEmail(), teacher.getEmail(), teacher.getPassword(), teacher.getProfilePictureId(), teacher.getDirector() != null ? teacher.getDirector().getPin() : null, teacher.getPin());
    }

    public Teacher findByPin(int pin) {
        String sql = "SELECT * FROM teachers WHERE teacher_pin = ?";
        try {
            return this.jdbcTemplate.queryForObject(sql, new Object[]{pin}, new TeacherRowMapper());
        } catch (EntityDoesntExistException e) {
            throw new EntityDoesntExistException(ConstantMessages.ENTITY_NOT_FOUND);
        }
    }

    public List<Teacher> findAll() {
        String sql = "SELECT * FROM teachers";
        List<Teacher> teachers = this.jdbcTemplate.query(sql, new TeacherRowMapper());
        if (teachers.isEmpty())
            throw new EntityDoesntExistException(ConstantMessages.NO_ENTITIES_REGISTERED);
        return teachers;
    }

    @Transactional
    public void delete(int pin) {
        if (!existsByPin(pin))
            throw new EntityDoesntExistException(ConstantMessages.ENTITY_NOT_FOUND);
        String sql = "DELETE FROM teachers WHERE teacher_pin = ?";
        this.jdbcTemplate.update(sql, pin);
    }

    private boolean existsByPin(int pin) {
        String sql = "SELECT COUNT(*) FROM teachers WHERE teacher_pin = ?";
        Integer count = this.jdbcTemplate.queryForObject(sql, Integer.class, pin);
        return count != null && count > 0;
    }
}