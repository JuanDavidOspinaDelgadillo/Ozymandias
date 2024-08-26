package com.users.controller;

import com.users.exceptions.MapException;
import com.users.exceptions.EntityAlreadyExistException;
import com.users.exceptions.EntityDoesntExistException;
import com.users.model.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Controller
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({MapException.class})
    public ResponseEntity<ErrorDTO> handleMapException(MapException e) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new ErrorDTO(HttpStatus.SERVICE_UNAVAILABLE, e.getMessage(), e.getClass().getSimpleName()));
    }

    @ExceptionHandler({EntityDoesntExistException.class})
    public ResponseEntity<ErrorDTO> handleStudentDoesntExistException(EntityDoesntExistException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO(HttpStatus.NOT_FOUND, e.getMessage(), e.getClass().getSimpleName()));
    }

    @ExceptionHandler({EntityAlreadyExistException.class})
    public ResponseEntity<ErrorDTO> handleStudentAlreadyExistException(EntityAlreadyExistException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorDTO(HttpStatus.CONFLICT, e.getMessage(), e.getClass().getSimpleName()));
    }
}
