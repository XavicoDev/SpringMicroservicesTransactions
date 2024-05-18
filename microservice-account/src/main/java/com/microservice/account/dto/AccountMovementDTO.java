package com.microservice.account.dto;

import com.microservice.account.dto.projections.MovementPrj;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountMovementDTO {
    private String accountNumber;
    private Double accountBalance;
    private List<MovementPrj> movementList;
}
