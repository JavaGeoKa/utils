package com.geo.controller;



import com.geo.dto.RequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class controller {


//    ssh -R 8081:localhost:8081 root@188.225.34.62

    @PostMapping("/http/")
    public ResponseEntity postHttpRequest(@RequestBody RequestDto requestDto,
                                          @RequestHeader Map<String, String> headers, HttpServletRequest request) {

        headers.forEach((key, value) -> {
            System.out.println(key + " -> " + value);
        });
        System.out.println(requestDto.getIdObject());
        System.out.println(requestDto.getContent());
        System.out.println(requestDto.getData());
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getLocalPort());
        return ResponseEntity.ok("ok");
    }




}
