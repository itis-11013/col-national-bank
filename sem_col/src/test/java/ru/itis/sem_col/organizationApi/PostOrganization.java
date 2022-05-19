package ru.itis.sem_col.organizationApi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class PostOrganization {
    public static void main(String[] args) throws JSONException, JsonProcessingException {
        String url = "http://188.93.211.195/central/organization";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject map = new JSONObject();
        map.put("name", "ProbeOrgCo");
        map.put("country", "co");
        map.put("address", "street 1992");
        map.put("url", "probeorgco.com");
        System.out.println(map);

        HttpEntity<String> request = new HttpEntity<String>(map.toString(), headers);

        RestTemplate restTemplate = new RestTemplate();
        String personResultAsJsonStr =
                restTemplate.postForObject(url, request, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(personResultAsJsonStr);
        JsonNode innerId = root.path("innerid");

    }
}
