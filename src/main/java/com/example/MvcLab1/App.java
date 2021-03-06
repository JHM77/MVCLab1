package com.example.MvcLab1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class App {

    private ArrayList<Task> taskList = new ArrayList<>();

    public List<Task> getList() {
        if (taskList != null){
            return taskList;
        }
        return null;
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
