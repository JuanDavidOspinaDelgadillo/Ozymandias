package com.users.controller.impl;

import com.users.controller.interfaces.ITeacherController;
import com.users.model.DTO.LoginDTO;
import com.users.model.DTO.teacher.TeacherRegisterDTO;
import com.users.model.DTO.teacher.TeacherViewDTO;
import com.users.model.commons.endpoints.EndPoints;
import com.users.service.interfaces.ITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndPoints.TEACHER)
@RequiredArgsConstructor
public class TeacherControllerImpl implements ITeacherController {

    final ITeacherService service;

    @Override
    @GetMapping(EndPoints.LOGIN)
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.service.login(loginDTO));
    }

    @Override
    @PostMapping
    public ResponseEntity<TeacherViewDTO> create(@RequestBody TeacherRegisterDTO teacherRegisterDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.service.create(teacherRegisterDTO));
    }

    @Override
    @GetMapping
    public ResponseEntity<TeacherViewDTO> read(@PathVariable Integer pin) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.service.read(pin));
    }

    @Override
    @PutMapping
    public ResponseEntity<TeacherViewDTO> update(@RequestBody TeacherRegisterDTO teacherRegisterDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.service.update(teacherRegisterDTO));
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Integer pin) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.service.delete(pin));
    }
}