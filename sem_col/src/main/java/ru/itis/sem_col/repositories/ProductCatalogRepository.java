package ru.itis.sem_col.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itis.sem_col.models.ProductCatalog;

import java.util.List;

public interface ProductCatalogRepository extends CrudRepository <ProductCatalog, Long> {
    @Query("select m from ProductCatalog m where code like :code ||'%' ")
    List<ProductCatalog> findByCode(@Param("code")String code);
    @Query("select m from ProductCatalog m where UPPER(name) like '%' ||  :name  ||'%'")
    List<ProductCatalog> findByName(@Param("name") String name);
}
