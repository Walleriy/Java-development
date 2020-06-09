package com.webserv.edu.controller;

import com.webserv.edu.model.Course;
import com.webserv.edu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    private final CourseService CourseService;

    @Autowired
    public CourseController(CourseService CourseService) {
        this.CourseService = CourseService;
    }

    @PostMapping(value = "/courses")
    public ResponseEntity<?> create(@RequestBody Course Course) {
        CourseService.create(Course);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> read() {
        final List<Course> Courses = CourseService.readAll();

        return Courses != null &&  !Courses.isEmpty()
                ? new ResponseEntity<>(Courses, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/courses/{id}")
    public ResponseEntity<Course> read(@PathVariable(name = "id") int id) {
        final Course Course = CourseService.read(id);

        return Course != null
                ? new ResponseEntity<>(Course, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/courses/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Course Course) {
        final boolean updated = CourseService.update(Course, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/courses/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = CourseService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
