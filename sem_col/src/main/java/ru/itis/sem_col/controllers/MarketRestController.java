package ru.itis.sem_col.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itis.sem_col.models.ProductCatalog;
import ru.itis.sem_col.services.ProductCatalogService;

import java.util.List;


@RestController
public class MarketRestController {
    @Autowired
    ProductCatalogService catalogService;

    @RequestMapping("/merch")
    public List<ProductCatalog> getAllMerch(@RequestParam("name") String name) {
        return catalogService.findByName(name);
    }

//    @PostMapping("/merch")
//    public ModelAndView registerUserAccount(@ModelAttribute("pruebaDto") @Valid PruebaDto productcatalog) throws JsonProcessingException {
////        List<ProductDto> products = marketServiceDetails.getCountryProducts("co");
//        System.out.println(productcatalog.getMerch_id());
//
//
////        return new ModelAndView("excelent", "product", productDto);
//        return new ModelAndView("excelent", "product", productcatalog);
//    }
}
