package ru.itis.sem_col.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.sem_col.models.ProductCatalog;
import ru.itis.sem_col.repositories.ProductCatalogRepository;

import java.util.List;

@Service
public class CatalogServiceimpl implements CatalogService{
    @Autowired
    ProductCatalogRepository productCatalogRepository;

    @Override
    public List<ProductCatalog> findByName(String name) {

        return productCatalogRepository.findByName(name);
    }

    @Override
    public List<ProductCatalog> findByCode(String code) {
        return productCatalogRepository.findByCode(code);
    }

    @Override
    public List<ProductCatalog> listAllProductCatlog() {
        return (List<ProductCatalog>) productCatalogRepository.findAll();
    }
}
