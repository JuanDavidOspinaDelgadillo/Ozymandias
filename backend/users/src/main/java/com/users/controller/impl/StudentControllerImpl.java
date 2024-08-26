package com.users.controller.impl;

import com.users.controller.interfaces.IStudentController;
import com.users.model.DTO.LoginDTO;
import com.users.model.DTO.student.StudentRegisterDTO;
import com.users.model.DTO.student.StudentViewDTO;
import com.users.model.commons.endpoints.EndPoints;
import com.users.service.interfaces.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentControllerImpl implements IStudentController {

    final IStudentService service;

    @Override
    @GetMapping(EndPoints.LOGIN)
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.service.login(loginDTO));
    }

    @Override
    @PostMapping
    public ResponseEntity<StudentViewDTO> create(@RequestBody StudentRegisterDTO studentRegisterDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.service.create(studentRegisterDTO));
    }

    @Override
    @GetMapping
    public ResponseEntity<StudentViewDTO> read(@PathVariable Integer pin) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.service.read(pin));
    }

    @Override
    @PutMapping
    public ResponseEntity<StudentViewDTO> update(@RequestBody StudentRegisterDTO studentRegisterDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.service.update(studentRegisterDTO));
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Integer pin) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.service.delete(pin));
    }
}