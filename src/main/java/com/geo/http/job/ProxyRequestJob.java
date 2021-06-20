package com.geo.http.job;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.geo.dto.ProxyDto;
import com.geo.http.service.ProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ProxyRequestJob {

    @Autowired
    ProxyService proxyService;

    @Scheduled(cron = "*/10 * * * * *")
    private void startJob () throws JsonProcessingException {

        ProxyDto proxyDto = proxyService.getProxy();
        System.out.println(proxyDto.getIp());
        System.out.println(proxyDto.getPort());

    }


}
