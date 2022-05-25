package com.project.componentprocessingservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "872509-api-gateway-lb-940625491.us-east-1.elb.amazonaws.com")
public interface AuthFeignClient {

    @GetMapping(value = "/auth/validate")
    public Boolean validateToken(@RequestHeader("Authorization") String token);

}

