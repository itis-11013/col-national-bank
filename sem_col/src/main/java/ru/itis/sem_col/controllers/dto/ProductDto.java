package ru.itis.sem_col.controllers.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import ru.itis.sem_col.models.Organization;
import ru.itis.sem_col.models.ProductCatalog;
import ru.itis.sem_col.models.Units;

@Getter
@Setter
public class ProductDto {
    private ProductCatalog catalog;
    private Units units;
    @NotNull
    private Long price;
    @NotNull
    private Integer count;
    private Organization organization;
}
