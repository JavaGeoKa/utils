package com.geo.http.job;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geo.dto.ProxyDto;
import com.geo.dto.RequestDto;
import com.geo.http.service.ProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;

@Component
public class ProxyRequestJob {

    @Autowired
    ProxyService proxyService;     //get proxy from provider

    static ObjectMapper mapper = new ObjectMapper();

    private String PROXY_SERVER_HOST;
    private Integer PROXY_SERVER_PORT;

    @Scheduled(cron = "*/10 * * * * *")
    private void startJob () throws JsonProcessingException {

        ProxyDto proxyDto = proxyService.getProxy();
        PROXY_SERVER_HOST = proxyDto.getIp();
        PROXY_SERVER_PORT = proxyDto.getPort();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RequestDto requestDto = RequestDto.builder()
                                    .idObject("newId")
                                     .content("content")
                                      .data(Arrays.asList("v1", "v2"))
                                       .build();



        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_SERVER_HOST, PROXY_SERVER_PORT));
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setProxy(proxy);


        RestTemplate restTemplate = new RestTemplate(requestFactory);


        HttpEntity<String> request =
                new HttpEntity<String>(requestDto.toString(), headers);

//        ResponseEntity response = restTemplate.exchange("188.225.34.62:8081/test/http/", HttpMethod.POST, request, RequestDto.class);
        ResponseEntity response = restTemplate.postForEntity("http://188.225.34.62:8081/test/http/", request, RequestDto.class);

        System.out.println(response.getStatusCode());



    }


}
