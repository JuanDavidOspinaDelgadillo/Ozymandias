package com.users.repository.director;

import com.users.exceptions.EntityAlreadyExistException;
import com.users.exceptions.EntityDoesntExistException;
import com.users.model.commons.constants.ConstantMessages;
import com.users.model.entities.Director;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class DirectorDAO {

    final JdbcTemplate jdbcTemplate;

    @Transactional
    public void save(Director director) {
        String checkSql = "SELECT COUNT(*) FROM directors WHERE director_pin = ?";
        int count = Optional.ofNullable(this.jdbcTemplate.queryForObject(checkSql, new Object[]{director.getPin()}, Integer.class)).orElse(0);
        if (count > 0)
            throw new EntityAlreadyExistException(ConstantMessages.ENTITY_ALREADY_EXISTS);
        String sql = "INSERT INTO directors (director_id, director_name, director_personal_email, director_email, director_password, director_profile_picture_id) VALUES (?, ?, ?, ?, ?, ?) RETURNING director_pin";
        Integer generatedPin = this.jdbcTemplate.queryForObject(sql, new Object[]{
                director.getPersonalId(), director.getName(), director.getPersonalEmail(), director.getEmail(),
                director.getPassword(), director.getProfilePictureId()
        }, Integer.class);
        director.setPin(generatedPin);
    }

    @Transactional
    public int update(Director director) {
        if (!existsByPin(director.getPin()))
            throw new EntityDoesntExistException(ConstantMessages.ENTITY_NOT_FOUND);
        String sql = "UPDATE directors SET director_id = ?, director_name = ?, director_personal_email = ?, director_email = ?, director_password = ?, director_profile_picture_id = ? WHERE director_pin = ?";
        return this.jdbcTemplate.update(sql, director.getPersonalId(), director.getName(), director.getPersonalEmail(), director.getEmail(), director.getPassword(), director.getProfilePictureId(), director.getPin());
    }

    public Director findByPin(int pin) {
        String sql = "SELECT * FROM directors WHERE director_pin = ?";
        try {
            return this.jdbcTemplate.queryForObject(sql, new Object[]{pin}, new DirectorRowMapper());
        } catch (EntityDoesntExistException e) {
            throw new EntityDoesntExistException(ConstantMessages.ENTITY_NOT_FOUND);
        }
    }

    public List<Director> findAll() {
        String sql = "SELECT * FROM directors";
        List<Director> directors = this.jdbcTemplate.query(sql, new DirectorRowMapper());
        if (directors.isEmpty())
            throw new EntityDoesntExistException(ConstantMessages.NO_ENTITIES_REGISTERED);
        return directors;
    }

    @Transactional
    public int delete(int pin) {
        if (!existsByPin(pin))
            throw new EntityDoesntExistException(ConstantMessages.ENTITY_NOT_FOUND);
        String sql = "DELETE FROM directors WHERE director_pin = ?";
        return this.jdbcTemplate.update(sql, pin);
    }

    private boolean existsByPin(int pin) {
        String sql = "SELECT COUNT(*) FROM directors WHERE director_pin = ?";
        Integer count = this.jdbcTemplate.queryForObject(sql, Integer.class, pin);
        return count != null && count > 0;
    }
}