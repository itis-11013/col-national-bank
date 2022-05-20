package ru.itis.sem_col.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.sem_col.controllers.dto.LoginFormDto;
import ru.itis.sem_col.controllers.dto.RegisterOrganizationDto;
import ru.itis.sem_col.repositories.OrganizationRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {
    @Autowired
    private OrganizationRepository repository;

    @GetMapping("/register")
    public String RegisterPage(Model model) {
        return "registerform";
    }

    @PostMapping("/registerformcheck")
    public String loginForm(HttpServletRequest request, Model model, RegisterOrganizationDto form) {

//        System.out.println(form.getName());
//        try {
//            request.login(form.getName(), form.getPassword());
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }
        return "/";
    }
}
