package com.webserv.edu.service;

import com.webserv.edu.model.Course;

import java.util.List;

public interface CourseService {

    /**
     * Создает нового викладача
     * @param Course - викладач для создания
     */
    void create(Course Course);

    /**
     * Возвращает список всех имеющихся викладачів
     * @return список викладачів
     */
    List<Course> readAll();

    /**
     * Возвращает клиента по его ID
     * @param id - ID викладача
     * @return - объект викладача с заданным ID
     */
    Course read(int id);

    /**
     * Обновляет викладача с заданным ID,
     * в соответствии с переданным викладачем
     * @param Course - викладач в соответсвии с которым нужно обновить данные
     * @param id - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Course Course, int id);

    /**
     * Удаляет клиента с заданным ID
     * @param id - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(int id);
}
