package com.project.componentprocessingservice.payload;

import lombok.Data;

import java.util.Date;

@Data
public class ReturnResponsePayload {
    private int requestId;
    private double processingCharge;
    private double packageAndDeliveryCharge;
    private Date dateOfDelivery;
}
