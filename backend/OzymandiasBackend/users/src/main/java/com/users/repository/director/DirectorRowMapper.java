package com.users.repository.director;

import com.users.model.entities.Director;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DirectorRowMapper implements RowMapper<Director> {

    @Override
    public Director mapRow(ResultSet rs, int rowNum) throws SQLException {
        Director director = new Director();
        director.setPin(rs.getInt("director_pin"));
        director.setPersonalId(rs.getString("director_id"));
        director.setName(rs.getString("director_name"));
        director.setPersonalEmail(rs.getString("director_personal_email"));
        director.setEmail(rs.getString("director_email"));
        director.setPassword(rs.getString("director_password"));
        director.setProfilePictureId(rs.getString("director_profile_picture_id"));
        return director;
    }
}