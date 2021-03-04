package com.example.MvcLab1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class App {

    private ArrayList<Task> taskList = new ArrayList<>();

    public void taskRepo() {
        taskList.add(new Task("Boka flytthjälp", "27 jan 08:00, 077-555 22 22 (Städjätten)", "Magnus", true));
        taskList.add(new Task("Teckna hemförsäkring", "If, 5846 kr/år", "Magnus", true));
        taskList.add(new Task("Teckna elnätsavtal", "Startdatum 27 jan (Nacka Energi)", "Magnus", true));
        taskList.add(new Task("Genomgång av larm", "3 feb 08:00-13:00 (Sector Alarm)", "Malin", true));
        taskList.add(new Task("Möte med banken", "21 jan 16:00", "Magnus", false));
    }

    public List<Task> getList() {
        return taskList;
    }

    public List<Task> searchRepo(String keyword) {
        ArrayList<Task> result = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getDescription().contains(keyword) || task.getComment().contains(keyword) || task.getOwner().contains(keyword)) {
                result.add(task);
            }
        }
        return result;
    }

    public void addTask (Task newTask) {
        taskList.add(newTask);
    }
}
