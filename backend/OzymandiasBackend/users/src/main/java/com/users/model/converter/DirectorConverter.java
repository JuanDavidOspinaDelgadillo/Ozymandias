package com.users.model.converter;

import com.users.exceptions.MapException;
import com.users.model.DTO.director.DirectorRegisterDTO;
import com.users.model.DTO.director.DirectorViewDTO;
import com.users.model.commons.constants.ConstantMessages;
import com.users.model.entities.Director;
import org.springframework.stereotype.Component;

@Component
public class DirectorConverter {

    public Director directorRegisterDTOToDirector(DirectorRegisterDTO directorRegisterDTO) {
        try {
            return new Director(directorRegisterDTO.getName(), directorRegisterDTO.getPersonalId(), directorRegisterDTO.getPersonalEmail());

        } catch (RuntimeException e) {
            throw new MapException(ConstantMessages.MAP_ERROR);
        }
    }

    public DirectorViewDTO directorToDirectorViewDTO(Director director) {
        try {
            return new DirectorViewDTO(director.getName(), director.getPersonalId(), director.getEmail(), director.getProfilePictureId());
        } catch (RuntimeException e) {
            throw new MapException(ConstantMessages.MAP_ERROR);
        }
    }
}