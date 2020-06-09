package com.webserv.edu.service.impl;

import com.webserv.edu.model.Lecturer;
import com.webserv.edu.repository.LecturerRepository;
import com.webserv.edu.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerServiceImpl implements LecturerService {

    @Autowired
    private LecturerRepository lecturerRepository;

    @Override
    public void create(Lecturer lecturer) {
        lecturerRepository.save(lecturer);
    }

    @Override
    public List<Lecturer>  readAll() {
        return lecturerRepository.findAll();
    }

    @Override
    public Lecturer read(int id) {
        return lecturerRepository.getOne(id);
    }

    @Override
    public boolean update(Lecturer lecturer, int id) {
        if (lecturerRepository.existsById(id)) {
            lecturer.setId(id);
            lecturerRepository.save(lecturer);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (lecturerRepository.existsById(id)) {
            lecturerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
