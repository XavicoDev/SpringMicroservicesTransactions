package com.microservice.customer.dto.projections;

public interface CustomerPrj {
    Long getId();
    String getPersonName();
    String getPersonGender();
    int getPersonAge();
    String getPersonIdentification();
    String getPersonAddress();
    String getPersonPhone();
    String getCustomerPassword();
    String getCustomerStatus();
}
