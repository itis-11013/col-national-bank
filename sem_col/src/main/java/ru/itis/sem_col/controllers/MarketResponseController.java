package ru.itis.sem_col.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.sem_col.models.ProductCatalog;
@Controller
public class MarketResponseController {

    @PostMapping("/merch")
    public ModelAndView postMerch(@ModelAttribute("productCatalog") String merge_id) throws JsonProcessingException {
        System.out.println(merge_id);
//        List<ProductDto> products = marketServiceDetails.getCountryProducts("co");
//        System.out.println(productcatalog.getId());


//        return new ModelAndView("excelent", "product", productDto);
        return new ModelAndView("excelent", "product", merge_id);
    }
}
