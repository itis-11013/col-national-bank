package ru.itis.sem_col.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.itis.sem_col.controllers.dto.ProductDto;
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
    public ru.itis.sem_col.models.Product registerNewProduct(ProductDto productDto) throws JsonProcessingException {
        ru.itis.sem_col.models.Product product = new ru.itis.sem_col.models.Product();
        product.setOrganization(organizationDetailService.getOrganization());

        product.setPrice(productDto.getPrice());
        product.setCount(productDto.getCount());
        product.setCatalog(productDto.getProduct());
        product.setUnit(productDto.getUnits());
        //sell product in server
        String url = "http://188.93.211.195/central/product";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject map = new JSONObject();
        map.put("code", productDto.getProduct().getCode());
        map.put("name", productDto.getProduct().getName());
        map.put("count", productDto.getCount());
        map.put("unit", productDto.getUnits().getCode());
        map.put("price", productDto.getPrice());
        map.put("sellerid", organizationDetailService.getOrganization().getInnerId().toString());
        System.out.println(map);
        HttpEntity<String> request = new HttpEntity<String>(map.toString(), headers);
        RestTemplate restTemplate = new RestTemplate();
        String personResultAsJsonStr =
                restTemplate.postForObject(url, request, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(personResultAsJsonStr);
        JsonNode innerId = root.path("innerid");
        System.out.println("InnerID New Product in Server: "+ innerId);
        UUID uuid = UUID.fromString(innerId.asText());
        product.setInnerId(uuid);

        productRepository.save(product);
        return product;
    }
}
