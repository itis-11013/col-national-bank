package ru.itis.sem_col.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.sem_col.models.ProductCatalog;

public interface ProductCatalogRepository extends CrudRepository <ProductCatalog, Long> {
}
