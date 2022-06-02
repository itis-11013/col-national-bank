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
import ru.itis.sem_col.repositories.ProductRepository;
import ru.itis.sem_col.repositories.UnitsRepository;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class MarketServiceDetails implements MarketService{
    @Autowired
    ProductCatalogRepository productCatalogRepository;

    @Autowired
    UnitsRepository unitsRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrganizationDetailService organizationDetailService;

    @Autowired
    ContractServiceDetails contractServiceDetails;

    @Override
    public List<ProductDto> getProductsInMarket() throws JsonProcessingException {
        List<ProductDto> allProducts = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://188.93.211.195/central/productlist";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
        System.out.println(response);
        ObjectMapper mapper =  new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode data = root.path("data");
        JsonNode content = data.path("content");
        Iterator<JsonNode> iterador = content.elements();
        while (iterador.hasNext()){
            ProductDto tempProductDto = new ProductDto();
            Product tempProduct = new Product();
            JsonNode temp = iterador.next();
            tempProductDto.setPrice(temp.path("price").asLong());//
            tempProduct.setPrice(temp.path("price").asLong());

            tempProductDto.setProduct(productCatalogRepository.findByName(temp.path("name").asText()).get(0));
            tempProduct.setCatalog(productCatalogRepository.findByName(temp.path("name").asText()).get(0));

            tempProductDto.setUnits(unitsRepository.findByCode(temp.path("unit").asText()));
            tempProduct.setUnit(unitsRepository.findByCode(temp.path("unit").asText()));

            tempProductDto.setCount(temp.path("count").asInt());//
            tempProduct.setCount(temp.path("count").asInt());

            UUID uuid = UUID.fromString(temp.path("sellerid").asText());
            tempProductDto.setOrganization(organizationRepository.findByInnerId(uuid));//
            tempProduct.setOrganization(organizationRepository.findByInnerId(uuid));

            UUID productInnerId = UUID.fromString(temp.path("productid").asText());
            tempProductDto.setInnerID(productInnerId);
            tempProduct.setInnerId(productInnerId);


            try {
                UUID uuid1 = productRepository.findByInnerId(productInnerId).getInnerId();
                System.out.println(uuid1.toString());
            }catch (Exception e){
                productRepository.save(tempProduct);
            }
            if (!Objects.equals(organizationDetailService.getOrganization().getInnerId().toString(), uuid.toString())){
                allProducts.add(tempProductDto);
            }

        }



        return allProducts;
    }
    public Boolean isProductInMarketSave(String code, Integer count) throws JsonProcessingException {


        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://188.93.211.195/central/productlist?code=" + code;
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
        System.out.println(response);
        ObjectMapper mapper =  new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode data = root.path("data");
        JsonNode content = data.path("content");

        if (root.findValue("name") != null){
            System.out.println(content.path("sellerid"));
            if (!Objects.equals(content.path("sellerid").asText(), organizationDetailService.getOrganization().getInnerId().toString())){
                contractServiceDetails.addNewContract(content.findValue("productid").asText(), count);
            }
            return true;
        }else{
            System.out.println("no esta en el mercado");
            return false;
        }
    }
}
