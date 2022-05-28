package ru.itis.sem_col.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.sem_col.models.Account;
import ru.itis.sem_col.models.Organization;
import ru.itis.sem_col.services.AccountServiceImpl;
import ru.itis.sem_col.services.OrganizationDetailService;

@Controller
public class RootController {

    @Autowired
    AccountServiceImpl accountservice;
    @Autowired
    OrganizationDetailService organizationDetailService;

    @GetMapping("/")
    public String getIndex(Model model) {
        Organization organization = organizationDetailService.getOrganization();
        Account account = accountservice.contextAccount().get(0);
        model.addAttribute("account", account);
        model.addAttribute("organization", organization);
        return "successfull";
    }
}