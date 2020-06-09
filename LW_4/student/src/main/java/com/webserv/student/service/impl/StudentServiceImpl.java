package main.java.com.webserv.student.service.impl;

import com.webserv.edu.model.Student;
import com.webserv.edu.repository.StudentRepository;
import com.webserv.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void create(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student>  readAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student read(int id) {
        return studentRepository.getOne(id);
    }

    @Override
    public boolean update(Student student, int id) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            studentRepository.save(student);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
