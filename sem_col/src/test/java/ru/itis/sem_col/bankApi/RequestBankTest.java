package ru.itis.sem_col.bankApi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class RequestBankTest {


    public static void main(String[] args) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://188.93.211.195/central/productlist?country=" + "co";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
        System.out.println(response);
        ObjectMapper mapper =  new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode data = root.path("data");
        JsonNode content = data.path("content");
        Iterator<JsonNode> iterador = content.elements();
        while (iterador.hasNext()){
            iterador.next().path("code").asText();
        }



    }

}
