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
import ru.itis.sem_col.models.Product;
import ru.itis.sem_col.models.ProductCatalog;
import ru.itis.sem_col.services.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MarketController {
    @Autowired
    MarketServiceDetails marketServiceDetails;
    @Autowired
    ProductCatalogCreateService catalogServiceimpl;

    @Autowired
    UnitServiceImpl unitServiceImpl;

    @Autowired
    ProductServiceImpl productService;
    @Autowired
    ContractServiceDetails contractServiceDetails;

    @GetMapping("/market")
    public String showRegistrationForm(WebRequest request, Model model) throws JsonProcessingException {
        List<ProductDto> products = marketServiceDetails.getCountryProducts("co");
        model.addAttribute("product", products);

        return "marketlist";
    }
    @PostMapping("/market")
    public ModelAndView registerUserAccount(@ModelAttribute("product") @Valid ProductDto productDto) throws JsonProcessingException {
        System.out.println(productDto.getProduct().getId());
        contractServiceDetails.addNewContract(productDto.getInnerID(), productDto.getCount());
        return new ModelAndView("excelent", "product", productDto);
    }
}
