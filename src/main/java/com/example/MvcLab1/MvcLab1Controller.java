package com.example.MvcLab1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MvcLab1Controller {

    @Autowired
    AppRepository repository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @PostMapping("/")
    public String loginPost(HttpSession session, @RequestParam String username, @RequestParam String password) {
        boolean isLoggedIn = false;
        if (username.equals("admin") && password.equals("123")) {
            isLoggedIn = true;
            session.setAttribute("username", username);
            session.setAttribute("isLoggedIn", isLoggedIn);
            return "redirect:/index";
        }
        return "login";

    }

    @GetMapping("/index")
    public String session(HttpSession session) {
        String username = (String)session.getAttribute("username");
        if (username != null) {
            return "index";
        }
        else {
            return "redirect:/";
        }
    }

    @GetMapping("/allTasks")
    public String allTasks(Model model) {
        List<Task> allTasks = repository.getList();
        model.addAttribute("allTasks", allTasks);
        return "allTasks";
    }

    @GetMapping("/toDo")
    public String toDo(Model model) {
        List<Task> tasksToDo = repository.getListToDo();
        model.addAttribute("tasksToDo", tasksToDo);
        return "toDo";
    }

    @GetMapping("/done")
    public String done(Model model) {
        List<Task> tasksDone = repository.getListDone();
        model.addAttribute("tasksDone", tasksDone);
        return "Done";
    }

    @PostMapping("/search")
    public String postSearch(Model model, @RequestParam String keyword) {
        List<Task> result = repository.searchRepo(keyword);
        model.addAttribute("result", result);
        return "search";
    }

    @PostMapping("/index")
    public String addTask(@RequestParam String description, @RequestParam String comment, @RequestParam String owner, @RequestParam (required = false, defaultValue = "false") Boolean isCompleted) {
        Task newTask = new Task(null, description, comment, owner, isCompleted);
        repository.addTask(newTask);

        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletResponse res){
        session.removeAttribute("username"); // this would be an ok solution
        session.removeAttribute("isLoggedIn");
        Cookie cookie = new Cookie("JSESSIONID", "");
        cookie.setMaxAge(0);
        res.addCookie(cookie);
        return "redirect:/";
    }
}
