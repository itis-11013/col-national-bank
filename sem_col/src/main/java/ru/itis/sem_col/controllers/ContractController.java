package ru.itis.sem_col.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.sem_col.controllers.dto.ProductDto;
import ru.itis.sem_col.models.Contract;
import ru.itis.sem_col.repositories.ContractRepository;
import ru.itis.sem_col.services.ContractService;
import ru.itis.sem_col.services.ContractServiceDetails;

import javax.validation.Valid;
import java.util.List;

public class ContractController {

    @Autowired
    ContractServiceDetails contractServiceDetails;


    @GetMapping("/payments")
    public String showContracts(WebRequest request, Model model) {
        List<Contract> contracts = contractServiceDetails.getAllContracts();

        model.addAttribute("contracts", contracts );
        return "contracts2";
    }

}
