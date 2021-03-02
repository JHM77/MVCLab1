package com.example.MvcLab1;

import org.springframework.stereotype.Controller;

@Controller
public class MvcLab1Controller {

    public String test(){
        String name = "Hej";
        return "test";
    }
}


