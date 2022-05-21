package ru.itis.sem_col.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.sem_col.controllers.dto.LoginFormDto;
import ru.itis.sem_col.controllers.dto.RegisterOrganizationDto;
import ru.itis.sem_col.models.Organization;
import ru.itis.sem_col.repositories.OrganizationRepository;
import ru.itis.sem_col.security.OrganizationDetailService;
import ru.itis.sem_col.services.OrganizationCreateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private OrganizationCreateService organizationDetailService;

    @GetMapping("/register")
    public String showRegistrationForm(WebRequest request, Model model) {
        RegisterOrganizationDto organizationDto = new RegisterOrganizationDto();
        model.addAttribute("organization", organizationDto);
        return "registerform";
    }

    @PostMapping("/register")
    public ModelAndView registerUserAccount(
            @ModelAttribute("organization") @Valid RegisterOrganizationDto organizationDto, HttpServletRequest request, Errors errors) {

        try {
            Organization registered = organizationDetailService.registerNewOrganization(organizationDto);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(("message An account for that username/email already exists."));
            return null;
        }

        return new ModelAndView("app", "Organization", organizationDto);
    }

}
