package de.ait.todoList.dao;

import de.ait.todoList.model.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TodoListImpl implements TodoList{
    private List<Task> taskList = new ArrayList<>();

    public TodoListImpl(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public String addTask(Task task) {
        if (task == null || taskList.contains(task)){
            return "task is empty or already exists";
        }
        taskList.add(task);
        return task.getNameTask();
    }

    @Override
    public void removeTask(int taskId) {
        taskList.removeIf(task -> task.getId()==taskId);
    }

    @Override
    public Task getTaskById(int taskId) {
        return taskList.stream()
                .filter(task -> task.getId() == taskId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Task> getTaskByName(String name) {
        return taskList.stream()
                .filter(task -> task.getNameTask().equalsIgnoreCase(name))
                .toList();
    }

    @Override
    public List<Task> getAllTasks() {
        return taskList;
    }

    @Override
    public List<Task> getСompletedTasks() {
        return taskList.stream()
                .filter(task -> task.isTaskStatus()==true).toList();
    }

    @Override
    public List<Task> getUncompletedTasks() {
        return taskList.stream()
                .filter(task -> task.isTaskStatus()==false).toList();
    }

    @Override
    public List<Task> getTasksByDate(LocalDate from, LocalDate to) {
        return taskList.stream()
                .filter(task -> task.getDate().isAfter(from)&&task.getDate().isBefore(to))
                .toList();
    }

    @Override
    public void updateTaskStatus(int taskId, boolean newStatus) {
        Task taskUpdate = getTaskById(taskId);
        if(taskUpdate != null) {
            taskUpdate.setTaskStatus(newStatus);
        }
    }

    @Override
    public void updateTaskName(int taskId, String newName) {
        Task taskUpdate = getTaskById(taskId);
        taskUpdate.setNameTask(newName);
    }
}
