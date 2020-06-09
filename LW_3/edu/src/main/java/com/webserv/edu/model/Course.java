package com.webserv.edu.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "lecturerId")
    private Integer lecturerId;

    @OneToMany
    @Column(name = "student")
    private Collection<Student> Cstudent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Integer lecturerId) {
        this.lecturerId = lecturerId;
    }

    public void addStudent(Student student) {
        Cstudent.add(student);
    }
}
