package ru.itis.sem_col.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.sem_col.controllers.dto.RegisterOrganizationDto;
import ru.itis.sem_col.models.Organization;
import ru.itis.sem_col.services.OrganizationDetailService;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @Autowired
    private OrganizationDetailService organizationDetailService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        RegisterOrganizationDto organizationDto = new RegisterOrganizationDto();
        model.addAttribute("organization", organizationDto);
        return "registerform";
    }

    @PostMapping("/register")
    public ModelAndView registerUserAccount(
            @ModelAttribute("organization") @Valid RegisterOrganizationDto organizationDto) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(organizationDto.getPassword());
            organizationDto.setPassword(encodedPassword);
        try {
            organizationDetailService.registerNewOrganization(organizationDto);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(("message An account for that username/email already exists."));
            return null;
        }

        return new ModelAndView("app", "Organization", organizationDto);
    }

}
