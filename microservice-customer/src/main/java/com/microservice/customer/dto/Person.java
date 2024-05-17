package com.microservice.customer.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@MappedSuperclass
public class Person {
    private String name;
    private String gender;
    private int age;
    private String identification;
    private String address;
    private String phone;
}
