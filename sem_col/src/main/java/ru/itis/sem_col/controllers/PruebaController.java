package ru.itis.sem_col.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.sem_col.models.ProductCatalog;
import ru.itis.sem_col.services.CatalogServiceimpl;

import java.util.List;

@RestController
public class PruebaController {
    @Autowired
    CatalogServiceimpl catalogServiceimpl;

    @RequestMapping("/lista")
    public List<ProductCatalog> getall(Model model, @RequestParam("name") String name) {
        return catalogServiceimpl.findByName(name);

    }
}
