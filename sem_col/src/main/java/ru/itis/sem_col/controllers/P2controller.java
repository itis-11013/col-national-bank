package ru.itis.sem_col.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class P2controller {
    @GetMapping("/listaa")
    public String getIndexp(Model model) {
        return "llista";
    }
}
