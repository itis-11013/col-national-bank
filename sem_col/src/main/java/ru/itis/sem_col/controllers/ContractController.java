package ru.itis.sem_col.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.sem_col.controllers.dto.ProductDto;
import ru.itis.sem_col.models.Contract;
import ru.itis.sem_col.services.ContractServiceDetails;

import javax.validation.Valid;
import java.util.List;
@Controller
public class ContractController {

    @Autowired
    ContractServiceDetails contractServiceDetails;


    @GetMapping("/payments")
    public String showContracts(WebRequest request, Model model) throws JsonProcessingException {
        List<Contract> contracts = contractServiceDetails.getAllContracts();
        for (Contract c: contracts) {
            System.out.println(c.isDeleted());
        }
        model.addAttribute("contracts", contracts );
        return "contracts";
    }
    @PostMapping("/payments")
    public ModelAndView registerUserAccount(@ModelAttribute("product") @Valid Contract contract) throws JsonProcessingException {
        contractServiceDetails.payContract(contract);
        System.out.println(contract.isDeleted());
        return new ModelAndView("excelent", "contract", contract);
    }
}
