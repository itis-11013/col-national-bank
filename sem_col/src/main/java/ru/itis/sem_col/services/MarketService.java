package ru.itis.sem_col.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.itis.sem_col.controllers.dto.ProductDto;

import java.util.List;

public interface MarketService {
    List<ProductDto> getProductsInMarket() throws JsonProcessingException;
}
