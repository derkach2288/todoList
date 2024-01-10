package de.ait.todoList.dao;

import de.ait.todoList.model.Task;

import java.time.LocalDate;
import java.util.List;

public interface TodoList {
    String addTask(Task task);  // Добавление задачи в список

    void removeTask(int taskId);     // Удаление задачи из списка по идентификатору

    Task getTaskById(int taskId);     // Получение задачи по идентификатору

    List<Task> getTaskByName(String name);     // Получение задачи по имени

    List<Task> getAllTasks();     // Получение списка всех задач

    List<Task> getСompletedTasks();     // Получение выполненых задач

    List<Task> getUncompletedTasks();     // Получение невыполненых задач
    List<Task> getTasksByDate(LocalDate from, LocalDate to);

    void updateTaskStatus(int taskId, boolean newStatus);     // Обновление статуса задачи

    void updateTaskName(int taskId, String newName);     // Обновление имени задачи

}
