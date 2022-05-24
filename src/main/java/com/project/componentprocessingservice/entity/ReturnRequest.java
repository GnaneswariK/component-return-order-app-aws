package com.project.componentprocessingservice.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ReturnRequests")
public class ReturnRequest {
    @Id
    @GeneratedValue
    private int requestId;
    private String userName;
    private long contactNumber;
    private String isPriority;

    private String componentType;
    private String componentName;
    private int quantity;
    
    private double processingCharge;
    private double packageAndDeliveryCharge;
    private Date dateOfDelivery;
    
	public ReturnRequest(String userName, long contactNumber, String isPriority, String componentType,
			String componentName, int quantity) {
		super();
		this.userName = userName;
		this.contactNumber = contactNumber;
		this.isPriority = isPriority;
		this.componentType = componentType;
		this.componentName = componentName;
		this.quantity = quantity;
	}


}
