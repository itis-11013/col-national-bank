package ru.itis.sem_col.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.sem_col.models.ProductCatalog;
import ru.itis.sem_col.repositories.ProductCatalogRepository;
import ru.itis.sem_col.services.MarketService;

import java.util.List;


@RestController
public class MarketRestController {

    @Autowired
    ProductCatalogRepository productCatalogRepository;
    @RequestMapping(
            value = "/merch"
    )
    public List<ProductCatalog> getAllMerch(Model model, @RequestParam("name") String name) {
        System.out.println(name);
        return productCatalogRepository.findByName(name);
    }
}
