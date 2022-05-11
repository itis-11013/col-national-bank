package ru.itis.sem_col.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.sem_col.models.Product;
import ru.itis.sem_col.models.composite.InnerProduct;

public interface ProductRepository extends CrudRepository<Product, InnerProduct> {
}
