package com.microservice.account.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomersDTO {
    private Long id;
    private String customerPassword;
    private String personIdentification;
    private String customerStatus;
    private String personAddress;
    private String personPhone;
    private String personGender;
    private int personAge;
    private String personName;
}
