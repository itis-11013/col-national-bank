package ru.itis.sem_col.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    //@Secured({"ADMIN"})
    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("text", "111");
        return "successfull";
    }
}