package ru.itis.sem_col.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;
import ru.itis.sem_col.services.MarketServiceDetails;

@Controller
public class MarketController {
    @Autowired
    MarketServiceDetails marketServiceDetails;

    @GetMapping("/market")
    public String showRegistrationForm(WebRequest request, Model model) throws JsonProcessingException {
        model.addAttribute("model", model);
        marketServiceDetails.getCountryProducts("co");
        return "marketlist";
    }
}
