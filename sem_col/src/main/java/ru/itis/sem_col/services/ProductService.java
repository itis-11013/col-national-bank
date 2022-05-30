package ru.itis.sem_col.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.itis.sem_col.controllers.dto.ProductDto;

public interface ProductService {

    ru.itis.sem_col.models.Product registerNewProduct(ProductDto productDto) throws JsonProcessingException;
}
