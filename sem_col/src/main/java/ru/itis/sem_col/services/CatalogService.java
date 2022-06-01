package ru.itis.sem_col.services;

import org.springframework.data.repository.CrudRepository;
import ru.itis.sem_col.models.ProductCatalog;

import java.util.List;

public interface CatalogService {
    List<ProductCatalog> findByName(String name);
    List<ProductCatalog> findByCode(String code);
    List<ProductCatalog> listAllProductCatalog();

}
