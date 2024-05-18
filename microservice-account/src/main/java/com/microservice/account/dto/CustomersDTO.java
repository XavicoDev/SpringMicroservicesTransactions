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
    private String personName;
    private String personGender;
    private int personAge;
    private String personIdentification;
    private String personAddress;
    private String personPhone;
}
