package de.ait;

import de.ait.todoList.dao.TodoList;
import de.ait.todoList.dao.TodoListImpl;
import de.ait.todoList.model.Menu;
import de.ait.todoList.model.Task;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TodoListAppl {
    private static final String FILE_NAME = "src/main/java/de/ait/todoList.csv";

    public static void main(String[] args) {

        List<Task> taskList = new ArrayList<>();
        TodoList todoList = new TodoListImpl(taskList);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu.printMenu();

            try {

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.println("Input ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Input name task");
                        String nameTask = scanner.nextLine();
                        System.out.println("Input name description");
                        String description = scanner.nextLine();
//                        System.out.println("Input task status: true/false");
//                        boolean taskStatus = scanner.nextBoolean();
//                        scanner.nextLine();
                        System.out.println("Input date YYY-MM-DD: ");
                        String dateStr = scanner.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate date = LocalDate.parse(dateStr, formatter);

                        taskList.add(new Task(id, nameTask, description, date));
                    }
                    case 2 -> {
                        System.out.println("All tasks");
                        todoList.getAllTasks().forEach(System.out::println);
                    }
                    case 3 -> {
                        System.out.println("Task by ID");
                        scanner.nextLine();
                        System.out.println("Input ID");
                        int id = scanner.nextInt();
                        System.out.println(todoList.getTaskById(id));
                    }

                    case 4 -> {
                        System.out.println("Task by title");
                        scanner.nextLine();
                        System.out.println("Input task name");
                        String taskName = scanner.nextLine();
                        todoList.getTaskByName(taskName).forEach(System.out::println);
                    }
                    case 5 -> {
                        System.out.println("Completed tasks");
                        todoList.getСompletedTasks().forEach(System.out::println);
                    }
                    case 6 -> {
                        System.out.println("Uncompleted tasks");
                        todoList.getUncompletedTasks().forEach(System.out::println);
                    }
                    case 7 -> {
                        System.out.println("Tasks by date");
                        scanner.nextLine();
                        System.out.println("Input date from YYY-MM-DD:");
                        String dateStrFrom = scanner.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate dateFrom = LocalDate.parse(dateStrFrom, formatter);

                        System.out.println("Input date to YYY-MM-DD:");
                        String dateStrTo = scanner.nextLine();
                        LocalDate dateTo = LocalDate.parse(dateStrTo, formatter);

                        todoList.getTasksByDate(dateFrom, dateTo).forEach(System.out::println);
                    }
                    case 8 -> {
                        System.out.println("Update task status");
                        System.out.println("Input ID");
                        int id = scanner.nextInt();
                        System.out.println("Input task status: true/false");
                        boolean taskStatus = scanner.nextBoolean();
                        todoList.updateTaskStatus(id, taskStatus);
                    }
                    case 9 -> {
                        System.out.println("Update task name");
                        System.out.println("Input ID");
                        int id = scanner.nextInt();
                        System.out.println("Input new name");
                        String newName = scanner.nextLine();
                        todoList.updateTaskName(id, newName);
                    }
                    case 10 -> {
                        System.out.println("Saving tasks...");
                        try(PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
                            pw.println("id,nameTask,description,taskStatus,date");
                            for (Task t :taskList){
                                pw.println(t);
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }
                    case 11 -> {
                        System.out.println("Loading...");

                        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
                            String str = br.readLine();
                            String[] cells = str.split(",");
                            printCells(cells);
                            str = br.readLine();
                            while (str != null) {
                                cells = str.split(",");
                                int id = Integer.parseInt(cells[0]);
                                String nameTask = cells[1];
                                String description = cells[2];
                                boolean taskStatus = Boolean.parseBoolean(cells[3]);
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                LocalDate date = LocalDate.parse(cells[4], formatter);
                                printCells(cells);
                                todoList.addTask(new Task(id, nameTask, description, taskStatus, date));
                                str = br.readLine();

                            }


                        } catch (IOException e){
                            throw new RuntimeException(e);
                        }
                    }
                    case 12 -> {
                        System.out.println("Deleting a task by ID");
                        int id = scanner.nextInt();
                        todoList.removeTask(id);
                    }

                    case 0 -> {
                        return;
                    }
                    default -> System.out.println("Wrong input.");

                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please, rty again.");
                scanner.nextLine();
            }
        }
    }

    private static void printCells(String[] cells) {
        for (String s : cells){
            System.out.print(s + "\t");
        }
        System.out.println();
    }
}