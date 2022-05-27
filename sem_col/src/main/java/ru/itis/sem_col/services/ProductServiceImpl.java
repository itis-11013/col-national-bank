package ru.itis.sem_col.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.sem_col.controllers.dto.ProductDto;
import ru.itis.sem_col.models.Organization;
import ru.itis.sem_col.models.Product;
import ru.itis.sem_col.repositories.ProductRepository;

import javax.transaction.Transactional;
import java.util.UUID;


@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    OrganizationDetailService organizationDetailService;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product registerNewProduct(ProductDto productDto) {
        Product product = new Product();
        product.setOrganization(organizationDetailService.getOrganization());
        UUID uuid = UUID.randomUUID();
        product.setInnerId(uuid);
        product.setPrice(productDto.getPrice());
        product.setCount(productDto.getCount());
        product.setCatalog(productDto.getProduct());
        product.setUnit(productDto.getUnits());

        productRepository.save(product);
        return product;
    }
}
