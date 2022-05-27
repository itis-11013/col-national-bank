package ru.itis.sem_col.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class MarketController {
    @GetMapping("/market")
    public String showRegistrationForm(WebRequest request, Model model) {
        model.addAttribute("model", model);
        return "marketlist";
    }
}
