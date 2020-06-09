package com.webserv.edu.service.impl;

import com.webserv.edu.model.Course;
import com.webserv.edu.repository.CourseRepository;
import com.webserv.edu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void create(Course course) {
        courseRepository.save(course);
    }

    @Override
    public List<Course>  readAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course read(int id) {
        return courseRepository.getOne(id);
    }

    @Override
    public boolean update(Course course, int id) {
        if (courseRepository.existsById(id)) {
            course.setId(id);
            courseRepository.save(course);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
