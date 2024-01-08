package de.ait.todoList.model;

import java.time.LocalDate;

public class Task {
    private int id;
    private String nameTask;
    private boolean taskStatus;
    private LocalDate date;

    public Task(int id, String nameTask, boolean taskStatus, LocalDate date) {
        this.id = id;
        this.nameTask = nameTask;
        this.taskStatus = taskStatus;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public boolean isTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(boolean taskStatus) {
        this.taskStatus = taskStatus;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return id == task.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", nameTask='" + nameTask + '\'' +
                ", taskStatus=" + taskStatus +
                ", date=" + date +
                '}';
    }
}
