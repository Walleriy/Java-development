package com.webserv.edu.service;

import com.webserv.edu.model.Lecturer;

import java.util.List;

public interface LecturerService {

    /**
     * Создает нового викладача
     * @param lecturer - викладач для создания
     */
    void create(Lecturer lecturer);

    /**
     * Возвращает список всех имеющихся викладачів
     * @return список викладачів
     */
    List<Lecturer> readAll();

    /**
     * Возвращает клиента по его ID
     * @param id - ID викладача
     * @return - объект викладача с заданным ID
     */
    Lecturer read(int id);

    /**
     * Обновляет викладача с заданным ID,
     * в соответствии с переданным викладачем
     * @param lecturer - викладач в соответсвии с которым нужно обновить данные
     * @param id - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Lecturer lecturer, int id);

    /**
     * Удаляет клиента с заданным ID
     * @param id - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(int id);
}
