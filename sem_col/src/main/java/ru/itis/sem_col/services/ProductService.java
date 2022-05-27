package ru.itis.sem_col.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.itis.sem_col.controllers.dto.ProductDto;
import ru.itis.sem_col.models.Organization;
import ru.itis.sem_col.models.Product;

public interface ProductService {

    Product registerNewProduct(ProductDto productDto) throws JsonProcessingException;
}
