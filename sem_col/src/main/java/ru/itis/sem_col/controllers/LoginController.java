package ru.itis.sem_col.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.sem_col.controllers.dto.LoginFormDto;
import ru.itis.sem_col.repositories.OrganizationRepository;
import ru.itis.sem_col.services.OrganizationDetailService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {



    @Autowired
    private OrganizationRepository repository;


    @GetMapping("/login")
    public String loginPage(Model model) {
        System.out.println(model);
        return "loginform";

    }

    @PostMapping("/usercheck")
    public String loginForm(HttpServletRequest request, Model model, LoginFormDto form) {

        System.out.println(form.getName() + "--------------");
        try {
            request.login(form.getName(), form.getPassword());
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return "/";
    }

}