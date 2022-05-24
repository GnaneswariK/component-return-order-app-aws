package com.project.componentprocessingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.componentprocessingservice.client.AuthFeignClient;
import com.project.componentprocessingservice.entity.ReturnRequest;
import com.project.componentprocessingservice.payload.ReturnRequestPayload;
import com.project.componentprocessingservice.payload.ReturnResponsePayload;
import com.project.componentprocessingservice.service.ReturnRequestService;

@RestController
@CrossOrigin(origins = "*",allowedHeaders="*")
@RequestMapping("/returns")
public class ReturnRequestController {
	
	private final AuthFeignClient authFeignClient;

    private final ReturnRequestService returnRequestService;

    @Autowired
    public ReturnRequestController(AuthFeignClient authFeignClient, ReturnRequestService returnRequestService) {
        this.authFeignClient = authFeignClient;
        this.returnRequestService = returnRequestService;
    }
    
    @PostMapping("/ProcessDetail")
    public ReturnResponsePayload createReturnRequest(
    		@RequestHeader("Authorization") String token,
                                                     @RequestBody ReturnRequestPayload returnRequestPayload) {
        authFeignClient.validateToken(token);
        return returnRequestService.processReturnRequest(returnRequestPayload);
    }
    
    @PostMapping("/CompleteProcessing")
    public String returnResponse(@RequestBody ReturnResponsePayload returnResponsePayload) {
        return "Processed successfully";
    }
}
