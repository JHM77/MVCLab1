package com.example.MvcLab1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class MvcLab1Controller {

    @Autowired
    AppRepository repository;

    @GetMapping("/")
    public String index(Model model) {
        List<Task> allTasks = repository.getListAll();
        model.addAttribute("allTasks", allTasks);
        return "index";
    }

    @PostMapping("/index")
    public String addTask(Model model, @RequestParam String description, @RequestParam String comment, @RequestParam String owner, @RequestParam (required = false, defaultValue = "false") Boolean isCompleted) {
        Task newTask = new Task(null, description, comment, owner, isCompleted);
        repository.addTask(newTask);
        List<Task> allTasks = repository.getListAll();
        model.addAttribute("allTasks", allTasks);
        return "index";
    }

    @GetMapping("/task/{id}")
    public String taskPage(Model model, @PathVariable Integer id) {
        Task task = repository.findById(id);
        if (task == null) {
            return "redirect:/";
        }
        model.addAttribute("task", task);
        return "taskPage";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(Model model, @PathVariable Integer id) {
        repository.deleteTask(id);
        List<Task> allTasks = repository.getListAll();
        model.addAttribute("allTasks", allTasks);
        return "redirect:/";
    }

    @PostMapping("/setTaskToCompleted/{id}")
    public String setTaskToCompleted(Model model, @PathVariable Integer id) {
        repository.setTaskToCompleted(id);
        List<Task> allTasks = repository.getListAll();
        model.addAttribute("allTasks", allTasks);
        return "redirect:/";
    }

    @GetMapping("/allTasks")
    public String allTasks(Model model) {
        List<Task> allTasks = repository.getListAll();
        model.addAttribute("allTasks", allTasks);
        return "index";
    }

    @GetMapping("/toDo")
    public String toDo(Model model) {
        List<Task> tasksToDo = repository.getListToDo();
        model.addAttribute("tasksToDo", tasksToDo);
        return "index";
    }

    @GetMapping("/done")
    public String done(Model model) {
        List<Task> tasksDone = repository.getListDone();
        model.addAttribute("tasksDone", tasksDone);
        return "index";
    }

    @PostMapping("/search")
    public String postSearch(Model model, @RequestParam String keyword) {
        List<Task> result = repository.searchRepo(keyword);
        model.addAttribute("result", result);
        return "index";
    }

    @GetMapping("/editTask/{id}")
    public String editTask(Model model, @PathVariable Integer id) {
        Task task = repository.findById(id);
        model.addAttribute("task", task);
        return "editTask";
    }

    @PostMapping("/editTask/{id}")
    public String editTaskPost(Model model, @ModelAttribute Task task, @PathVariable Integer id) {
        repository.editTask(id,task);
        List<Task> allTasks = repository.getListAll();
        model.addAttribute("allTasks", allTasks);
        return "redirect:/";
    }
}
