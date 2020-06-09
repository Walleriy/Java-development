package main.java.com.webserv.student.service;

import com.webserv.edu.model.Student;

import java.util.List;

public interface StudentService {

    /**
     * Создает нового клиента
     * @param student - клиент для создания
     */
    void create(Student student);

    /**
     * Возвращает список всех имеющихся клиентов
     * @return список клиентов
     */
    List<Student> readAll();

    /**
     * Возвращает клиента по его ID
     * @param id - ID клиента
     * @return - объект клиента с заданным ID
     */
    Student read(int id);

    /**
     * Обновляет клиента с заданным ID,
     * в соответствии с переданным клиентом
     * @param student - клиент в соответсвии с которым нужно обновить данные
     * @param id - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Student student, int id);

    /**
     * Удаляет клиента с заданным ID
     * @param id - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(int id);
}
