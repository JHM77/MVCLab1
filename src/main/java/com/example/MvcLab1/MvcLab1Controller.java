package com.example.MvcLab1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
public class MvcLab1Controller {

    @Autowired
    App app = new App();

    @GetMapping("/")
    public String loginGet() {
        return "login";
    }

    @PostMapping("/")
    public String loginPost(HttpSession session, @RequestParam String username, @RequestParam String password) {
        if (username.equals("admin") && password.equals("123")) {
            session.setAttribute("username", username);
            return "index";
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
        List<Task> taskList = app.taskRepo();
        model.addAttribute("taskList", taskList);

        return "allTasks";
    }

    @GetMapping("/toDo")
    public String toDo(Model model) {
        List<Task> taskList = app.taskRepo();
        model.addAttribute("taskList", taskList);

        return "toDo";
    }

    @GetMapping("/completed")
    public String completed(Model model) {
        List<Task> taskList = app.taskRepo();
        model.addAttribute("taskList", taskList);

        return "completed";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletResponse res){
        session.removeAttribute("username"); // this would be an ok solution
        //session.invalidate(); // you could also invalidate the whole session, a new session will be created the next request
        Cookie cookie = new Cookie("JSESSIONID", "");
        cookie.setMaxAge(0);
        res.addCookie(cookie);
        return "redirect:/";
    }
}


