package ru.itis.sem_col.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;
import ru.itis.sem_col.models.ProductCatalog;
import ru.itis.sem_col.models.Units;
import ru.itis.sem_col.services.ProductCatalogService;
import ru.itis.sem_col.services.UnitServiceImpl;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductCatalogService catalogServiceimpl;

    @Autowired
    UnitServiceImpl unitServiceImpl;

    @GetMapping("/product/add")
    public String addProduct(WebRequest request, Model model) {
        List<ProductCatalog> products = catalogServiceimpl.listAllProductCatlog();
        List<Units> units = unitServiceImpl.listAllUnits();
        model.addAttribute("product", products );
        model.addAttribute("units", units );
        return "addproduct";
    }


}
