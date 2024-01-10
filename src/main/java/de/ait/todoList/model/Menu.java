package de.ait.todoList.model;

public enum Menu {
    ADD_TASK(1,"Add task"),
    ALL_TASKS(2,"All tasks"),
    GET_TASK_BY_ID(3,"Getting a task by ID"),
    GET_TASK_BY_NAME(4,"Getting a task by name"),
    COMPLETED_TASKS(5,"Completed tasks"),
    UNCOMPLETED_TASKS(6,"Uncompleted tasks"),
    TASKS_BY_DATE (7,"Tasks by date"),
    UPDATE_STATUS (8,"Update task status"),
    UPDATE_NAME (9,"Update task name"),
    SAVE(10,"Save"),
    LOAD(11,"Load"),
    REMOVE_TASK(12,"Deleting a task by ID"),
    EXIT(0,"Exit");
    private int id;
    private String item;

    Menu(int id, String item) {
        this.id = id;
        this.item = item;
    }

    public static void printMenu(){
        Menu[] menu = Menu.values();
        for (int i = 0; i < menu.length; i++) {
            System.out.print(menu[i].id + ": " + menu[i].item + " | ");
        }
        System.out.println();
    }
}
