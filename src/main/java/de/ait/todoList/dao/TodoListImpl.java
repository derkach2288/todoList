package de.ait.todoList.dao;

import de.ait.todoList.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TodoListImpl implements TodoList{
    private List<Task> taskList;

    public TodoListImpl(List<Task> taskList) {
        this.taskList = new ArrayList<>();
    }

    @Override
    public void addTask(Task task) {

    }

    @Override
    public void removeTask(int taskId) {

    }

    @Override
    public Task getTaskById(int taskId) {
        return null;
    }

    @Override
    public Task getTaskByName(String name) {
        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        return null;
    }

    @Override
    public List<Task> getСompletedTasks() {
        return null;
    }

    @Override
    public List<Task> getOutstandingTasks() {
        return null;
    }

    @Override
    public void updateTaskStatus(int taskId, boolean newStatus) {

    }

    @Override
    public void updateTaskName(int taskId, String newName) {

    }
}
