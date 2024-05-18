package com.microservice.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovementDetailDTO {
    private String accountNumber;
    private Date movementDate;
    private Double movementValue;
    private String movementType;
    private Double movementBalance;
}
