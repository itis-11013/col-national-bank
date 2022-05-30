package ru.itis.sem_col.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.itis.sem_col.models.Contract;
import ru.itis.sem_col.models.Product;
import ru.itis.sem_col.repositories.ProductRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class ContractServiceDetails implements ContractService{
    @Autowired
    OrganizationDetailService organizationDetailService;

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Contract> getAllContracts() {



        return null;
    }

    @Override
    public Contract addNewContract(UUID productUUID, Integer count) throws JsonProcessingException {
        Contract contract = new Contract();
        //get data from server
        String url = "http://188.93.211.195/central/contract";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject map = new JSONObject();
        map.put("productid", productUUID.toString());
        map.put("count", count);
        map.put("buyerid", organizationDetailService.getOrganization().getInnerId().toString());
        System.out.println(map);
        HttpEntity<String> request = new HttpEntity<String>(map.toString(), headers);
        RestTemplate restTemplate = new RestTemplate();
        String personResultAsJsonStr =
                restTemplate.postForObject(url, request, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(personResultAsJsonStr);
        JsonNode innerId = root.path("innerid");
        System.out.println("InnerID New Contract in Server: "+ innerId);
        UUID uuid = UUID.fromString(innerId.asText());
        LocalDateTime contractDate = LocalDateTime.parse(root.path("createdAt").asText());
        //LocalDateTime paymentDate = LocalDateTime.parse(root.path("");
        contract.setInnerId(uuid);
        contract.setContractDate(contractDate);
        //contract.setCount(root.path("count").asDouble());
        contract.setDeleted(root.path("isPaid").asBoolean());
        JsonNode data = root.path("data");

        contract.setCount(data.path("count").asDouble());
        contract.setProduct(productRepository.findByInnerId(productUUID));
        contract.setBuyer(organizationDetailService.getOrganization());
        contract.setDeliveryDate(contractDate);
        contract.setPaymentDate(contractDate);
        return null;
    }
}
