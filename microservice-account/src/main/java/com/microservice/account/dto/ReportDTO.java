package com.microservice.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportDTO {

    private String identification;
    private String personName;
    private List<AccountMovementDTO> accountList;
}
