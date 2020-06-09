package com.webserv.edu.controller;

import com.webserv.edu.model.Lecturer;
import com.webserv.edu.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LecturerController {

    private final LecturerService lecturerService;

    @Autowired
    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @PostMapping(value = "/clients")
    public ResponseEntity<?> create(@RequestBody Lecturer lecturer) {
        lecturerService.create(lecturer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/clients")
    public ResponseEntity<List<Lecturer>> read() {
        final List<Lecturer> lecturers = lecturerService.readAll();

        return lecturers != null &&  !lecturers.isEmpty()
                ? new ResponseEntity<>(lecturers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<Lecturer> read(@PathVariable(name = "id") int id) {
        final Lecturer lecturer = lecturerService.read(id);

        return lecturer != null
                ? new ResponseEntity<>(lecturer, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Lecturer lecturer) {
        final boolean updated = lecturerService.update(lecturer, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = lecturerService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
