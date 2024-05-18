package com.microservice.customer.dto.projections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPrjImpl implements CustomerPrj {
    private Long id;
    private String personName;
    private String personGender;
    private int personAge;
    private String personIdentification;
    private String personAddress;
    private String personPhone;
    private String customerPassword;
    private String customerStatus;
}
