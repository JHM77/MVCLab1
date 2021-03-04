package com.example.MvcLab1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class App {

    private ArrayList<Task> taskList;

    public List<Task> taskRepo() {
        taskList = new ArrayList<>();

        taskList.add(new Task("Boka flytthjälp", "27 jan 08:00, 077-555 22 22 (Städjätten)", "Magnus", true));
        taskList.add(new Task("Boka flyttstädning", "28 jan 08:00, 077-555 22 22 (Städjätten)", "Magnus", true));
        taskList.add(new Task("Teckna bilförsäkring", "If, 1806 kr/halvår", "Magnus", true));
        taskList.add(new Task("Teckna hemförsäkring", "If, 5846 kr/år", "Magnus", true));
        taskList.add(new Task("Boka slutmätning el", "Uppsagt 28 jan (Fortum)", "Magnus", true));
        taskList.add(new Task("Teckna elnätsavtal", "Startdatum 27 jan (Nacka Energi)", "Magnus", true));
        taskList.add(new Task("Teckna abbonnemang el", "Startdatum 27 jan (Kundkraft)", "Magnus", true));
        taskList.add(new Task("Genomgång av larm", "3 feb 08:00-13:00 (Sector Alarm)", "Magnus", true));
        taskList.add(new Task("Möte med banken ang. bolån", "21 jan 16:00", "Magnus", true));
        taskList.add(new Task("Boka hemleverans av soffa", "Royal Design, tel: 010-750 27 88", "Malin", false));
        taskList.add(new Task("Undersöka lån av bilbarnstol", "Kontakta Lina", "Malin", false));
        taskList.add(new Task("Blankett för sophämtning", "Klart, mailat till nuvarande ägare", "Malin", true));
        taskList.add(new Task("Åtkomst till tvättstugan", "Kommer in med allmänna nyckeln", "Magnus", true));
        taskList.add(new Task("Sälja byrån", "Såld via Blocket", "Magnus", true));
        taskList.add(new Task("Sälja mikrovågsugnen", "Såld till nya ägarna", "Magnus", true));

        return taskList;
    }

    public List<Task> searchRepo(String keyword) {
        ArrayList<Task> result = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getDescription().contains(keyword) || task.getComment().equals(keyword) || task.getOwner().equals(keyword)) {
                result.add(task);
            }
        }
        return result;
    }
}
