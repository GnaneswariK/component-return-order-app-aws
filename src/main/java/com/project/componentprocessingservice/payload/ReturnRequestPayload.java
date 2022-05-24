package com.project.componentprocessingservice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReturnRequestPayload {
    private String userName;
    private long contactNumber;
    private String isPriority;

    private String componentType;
    private String componentName;
    private int quantity;
}
