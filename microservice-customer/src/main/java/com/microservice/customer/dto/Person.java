package com.microservice.customer.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.*;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person extends Base {
    private String name;
    private String gender;
    private int age;
    private String identification;
    private String address;
    private String phone;
}
