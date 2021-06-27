package com.geo.http.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geo.dto.ProxyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProxyService {



    @Autowired
    RestTemplate restTemplate;

    static ObjectMapper mapper = new ObjectMapper();

    public ProxyDto getProxy() throws JsonProcessingException {

        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-key", "1b965ad24fmsh22ee993fe445cfdp140f29jsn674d5c2e08cd");
        headers.add("x-rapidapi-host", "proxy-orbit1.p.rapidapi.com");

        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity response = restTemplate.exchange("https://proxy-orbit1.p.rapidapi.com/v1/", HttpMethod.GET, entity, String.class);

        return mapper.readValue(response.getBody().toString(), ProxyDto.class);
    }



}
