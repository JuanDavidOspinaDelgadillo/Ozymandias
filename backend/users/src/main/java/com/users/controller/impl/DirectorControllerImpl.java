package com.users.controller.impl;

import com.users.controller.interfaces.IDirectorController;
import com.users.model.DTO.LoginDTO;
import com.users.model.DTO.director.DirectorRegisterDTO;
import com.users.model.DTO.director.DirectorViewDTO;
import com.users.model.DTO.teacher.TeacherViewDTO;
import com.users.model.commons.endpoints.EndPoints;
import com.users.service.interfaces.IDirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/director")
public class DirectorControllerImpl implements IDirectorController {

    final IDirectorService service;


    @Override
    @GetMapping(EndPoints.LOGIN)
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.service.login(loginDTO));
    }

    @Override
    @PostMapping
    public ResponseEntity<DirectorViewDTO> create(@RequestBody DirectorRegisterDTO directorRegisterDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.service.create(directorRegisterDTO));
    }

    @Override
    @GetMapping
    public ResponseEntity<DirectorViewDTO> read(@PathVariable Integer pin) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.service.read(pin));
    }

    @Override
    @PutMapping
    public ResponseEntity<DirectorViewDTO> update(@RequestBody DirectorRegisterDTO directorRegisterDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.service.update(directorRegisterDTO));
    }

    @Override
    @DeleteMapping(EndPoints.TEACHER)
    public ResponseEntity<String> deleteTeacher(@PathVariable Integer pin) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.service.deleteTeacher(pin));
    }

    @Override
    @GetMapping(EndPoints.TEACHER)
    public ResponseEntity<List<TeacherViewDTO>> readAllTeachersByDirector(@PathVariable Integer pin) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.service.readAllTeacherByDirector(pin));
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Integer pin) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.service.delete(pin));
    }
}