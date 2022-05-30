package ru.itis.sem_col.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itis.sem_col.models.Product;
import ru.itis.sem_col.models.composite.InnerProduct;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, InnerProduct> {
    Product findByInnerId(UUID uuid);
}
