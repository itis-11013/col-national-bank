package ru.itis.sem_col.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.itis.sem_col.controllers.dto.ProductDto;
import ru.itis.sem_col.models.Product;

public class ProductServiceImpl implements ProductService{
    @Override
    public Product registerNewProduct(ProductDto productDto) throws JsonProcessingException {
        Product product = new Product();
        return product;
    }
}
