package ru.itis.sem_col.controllers.dto;

import lombok.Getter;
import lombok.Setter;
import ru.itis.sem_col.models.ProductCatalog;
import ru.itis.sem_col.models.Units;

@Getter
@Setter
public class AddProductDto {
    private String code;

    private String name;

    private Units unit;

    private ProductCatalog catalog;
}
