package com.project.componentprocessingservice.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.componentprocessingservice.client.PackagingAndDeliveryFeignClient;
import com.project.componentprocessingservice.entity.ReturnRequest;
import com.project.componentprocessingservice.payload.ReturnRequestPayload;
import com.project.componentprocessingservice.payload.ReturnResponsePayload;
import com.project.componentprocessingservice.repository.ReturnRequestRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReturnRequestService {
	private final ReturnRequestRepository returnRequestRepository;
	private final PackagingAndDeliveryFeignClient packagingAndDeliveryFeignClient;

	@Autowired
	public ReturnRequestService(ReturnRequestRepository returnRequestRepository,
			PackagingAndDeliveryFeignClient packagingAndDeliveryFeignClient) {
		this.returnRequestRepository = returnRequestRepository;
		this.packagingAndDeliveryFeignClient = packagingAndDeliveryFeignClient;
	}

	public ReturnResponsePayload processReturnRequest(ReturnRequestPayload returnRequestPayload) {
		ReturnRequest returnRequest = new ReturnRequest();
		ReturnResponsePayload returnResponsePayload = new ReturnResponsePayload();

		BeanUtils.copyProperties(returnRequestPayload, returnRequest);

		int processingDays = 5;
		double processingCharge = returnRequestPayload.getComponentType().equalsIgnoreCase("integral") ? 500 : 300;

		LocalDate date = LocalDate.now().plusDays(processingDays);
		returnRequest.setProcessingCharge(processingCharge);
		returnRequest.setDateOfDelivery(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		returnRequest.setRequestId(returnRequest.getRequestId());

		returnRequest.setPackageAndDeliveryCharge(packagingAndDeliveryFeignClient.getPackagingAndDeliveryCharge(
				returnRequestPayload.getComponentType(), returnRequestPayload.getQuantity()));

		returnRequestRepository.save(returnRequest);

		BeanUtils.copyProperties(returnRequest, returnResponsePayload);

		return returnResponsePayload;

	}

}
