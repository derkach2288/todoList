package de.ait.todoList.tests;

import de.ait.todoList.dao.TodoList;
import de.ait.todoList.dao.TodoListImpl;
import de.ait.todoList.model.Task;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoListImplTest {

    private List<Task> taskList = new ArrayList<>();
    TodoList todoList = new TodoListImpl(taskList);

    @BeforeEach
    void setUp() {
        taskList = List.of(
                new Task(1,"buy products", "bread, carrots, meat", false, LocalDate.of(2023, 12, 01)),
                new Task(2,"dentist", "visit to the dentist", false, LocalDate.of(2023, 12, 03)),
                new Task(3,"homework", "do homework", true, LocalDate.of(2023, 12, 31))
        );
        for (Task t :taskList) {
            todoList.addTask(t);
        }
    }

    @Test
    void addTask() {
        Task task4 = new Task(4,"sleep", "sleep until 8 am", true, LocalDate.of(2023, 12, 20));
        assertEquals("sleep", todoList.addTask(task4));
        assertEquals("task is empty or already exists", todoList.addTask(task4));
    }

    @Test
    void removeTask() {
        todoList.removeTask(2);
        assertNull(todoList.getTaskById(2));
    }

    @Test
    void getTaskById() {
        assertEquals(taskList.get(1), todoList.getTaskById(2));
    }

    @Test
    void getTaskByName() {
        List<Task> res = List.of(taskList.get(1));
        assertEquals(res, todoList.getTaskByName("dentist"));
    }

    @Test
    void getAllTasks() {
        assertEquals(3, todoList.getAllTasks().size());
    }

    @Test
    void getСompletedTasks() {
        List<Task> res = List.of(taskList.get(2));
        assertEquals(res, todoList.getСompletedTasks());
    }

    @Test
    void getOutstandingTasks() {
        List<Task> res = List.of(taskList.get(0), taskList.get(1));
        assertEquals(res, todoList.getOutstandingTasks());

    }

    @Test
    void getTasksByDate() {
        List<Task> res = List.of(taskList.get(0), taskList.get(1));
        LocalDate from = LocalDate.of(2023, 12, 01).minusDays(1);
        LocalDate to = LocalDate.of(2023, 12, 03).plusDays(1);
        assertEquals(res, todoList.getTasksByDate(from, to));

    }

    @Test
    void updateTaskStatus() {
        todoList.updateTaskStatus(1, true);
        assertTrue(todoList.getTaskById(1).isTaskStatus());
        todoList.updateTaskStatus(3, false);
        assertFalse(todoList.getTaskById(3).isTaskStatus());
    }

    @Test
    void updateTaskName() {
        todoList.updateTaskName(1, "sell products");
        assertEquals("sell products", taskList.get(0).getNameTask() );
    }
}