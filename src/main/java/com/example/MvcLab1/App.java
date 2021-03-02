package com.example.MvcLab1;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    Scanner scanner = new Scanner(System.in);

    private ArrayList<Task> taskList = new ArrayList<>();

    public void allTasks() {
        int count = 0;

        for (Task tasks : taskList ) {
            count++;
        }
        System.out.println("\nTasks found: " + count);
        System.out.format("\n%-45s %-45s %-15s %-10s\n", "Description", "Comment", "Owner", "Completed");

        for (Task task : taskList) {
            System.out.format("%-45s %-45s %-15s %-10s\n", task.getDescription(), task.getComment(), task.getOwner(), task.booleanToString(task.isCompleted()));
        }
    }

    public void toDo() {
        int count = 0;

        for (Task todo : taskList) {
            if (!todo.isCompleted()) {
                count++;
            }
        }
        System.out.println("\nTasks to do: " + count);
        System.out.format("\n%-45s %-45s %-15s %-10s\n", "Description", "Comment", "Owner", "Completed");

        for (Task todo : taskList) {
            if (!todo.isCompleted()) {
                System.out.format("%-45s %-45s %-15s %-10s\n", todo.getDescription(), todo.getComment(), todo.getOwner(), todo.booleanToString(todo.isCompleted()));
            }
        }
    }

    public void completed() {
        int count = 0;

        for (Task todo : taskList) {
            if (todo.isCompleted()) {
                count++;
            }
        }
        System.out.println("\nTasks completed: " + count);
        System.out.format("\n%-45s %-45s %-15s %-10s\n", "Description", "Comment", "Owner", "Completed");

        for (Task todo : taskList) {
            if (todo.isCompleted()) {
                System.out.format("%-45s %-45s %-15s %-10s\n", todo.getDescription(), todo.getComment(), todo.getOwner(), todo.booleanToString(todo.isCompleted()));
            }
        }
    }

    public void searchTask() {
        System.out.print("Enter keyword: ");
        String keyword = scanner.next();
        int count = 0;

        for (Task search : taskList) {
            if (search.getDescription().contains(keyword) || search.getOwner().contains(keyword) || search.getComment().contains(keyword)) {
                count++;
            }
        }
        System.out.println("\nTasks found: " + count);

        if (count > 0) {
            System.out.format("\n%-45s %-45s %-15s %-10s\n", "Description", "Comment", "Owner", "Completed");
        }
        for (Task search : taskList) {
            if (search.getDescription().contains(keyword) || search.getOwner().contains(keyword) || search.getComment().contains(keyword)) {
                System.out.format("%-45s %-45s %-15s %-10s\n", search.getDescription(), search.getComment(), search.getOwner(), search.booleanToString(search.isCompleted()));
            }
        }
    }

    public void addTasks() {
        taskList.add(new Task("Boka flytthjälp", "27 jan 08:00, 077-555 22 22 (Städjätten)", "Magnus",true));

    }
}
