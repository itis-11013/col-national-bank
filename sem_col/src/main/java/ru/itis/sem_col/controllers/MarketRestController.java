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
}
