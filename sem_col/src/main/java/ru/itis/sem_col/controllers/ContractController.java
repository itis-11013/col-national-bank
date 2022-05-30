package ru.itis.sem_col.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;
import ru.itis.sem_col.models.Contract;
import ru.itis.sem_col.services.ContractServiceDetails;

import java.util.List;
@Controller
public class ContractController {

    @Autowired
    ContractServiceDetails contractServiceDetails;


    @GetMapping("/payments")
    public String showContracts(WebRequest request, Model model) {
        List<Contract> contracts = contractServiceDetails.getAllContracts();

        model.addAttribute("contracts", contracts );
        return "contracts";
    }

}
