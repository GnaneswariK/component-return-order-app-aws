package com.project.componentprocessingservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "packaging-and-delivery-service")
public interface PackagingAndDeliveryFeignClient {
	@GetMapping("/packagingAndDelivery/GetPackagingAndDeliveryCharge/{componentType}/{quantity}")
    public double getPackagingAndDeliveryCharge(@PathVariable String componentType, @PathVariable int quantity);
}
