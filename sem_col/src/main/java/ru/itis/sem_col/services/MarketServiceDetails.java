package ru.itis.sem_col.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.itis.sem_col.controllers.dto.ProductDto;
import ru.itis.sem_col.models.Product;
import ru.itis.sem_col.repositories.OrganizationRepository;
import ru.itis.sem_col.repositories.ProductCatalogRepository;
import ru.itis.sem_col.repositories.UnitsRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class MarketServiceDetails implements MarketService{
    @Autowired
    ProductCatalogRepository productCatalogRepository;

    @Autowired
    UnitsRepository unitsRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Override
    public List<ProductDto> getCountryProducts(String country) throws JsonProcessingException {
        List<ProductDto> allProducts = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://188.93.211.195/central/productlist?country=" + country;
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
        System.out.println(response);
        ObjectMapper mapper =  new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode data = root.path("data");
        JsonNode content = data.path("content");
        Iterator<JsonNode> iterador = content.elements();
        while (iterador.hasNext()){
            ProductDto tempProduct = new ProductDto();
            JsonNode temp = iterador.next();
            UUID uuid = UUID.fromString(temp.path("sellerid").asText());
            tempProduct.setProduct(productCatalogRepository.findByName(temp.path("name").asText()).get(0));
            tempProduct.setCount(temp.path("count").asInt());
            tempProduct.setPrice(temp.path("price").asLong());
            tempProduct.setUnits(unitsRepository.findByCode(temp.path("unit").asText()));
            tempProduct.setOrganization(organizationRepository.findByInnerId(uuid));
            tempProduct.setInnerID(UUID.fromString(temp.path("productid").asText()));
            allProducts.add(tempProduct);
            System.out.println(tempProduct);
        }



        return allProducts;
    }
}
