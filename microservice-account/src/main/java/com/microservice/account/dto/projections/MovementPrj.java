package com.microservice.account.dto.projections;

import java.util.Date;

public interface MovementPrj {
    Long getAccountId();
    Date getMovementDate();
    String getMovementType();
    Double getMovementValue();
    Double getMovementBalance();
}
