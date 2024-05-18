package com.microservice.customer.dto;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person extends Base {
    @Column(name = "person_name",unique = true)
    private String personName;
    @Column(name = "person_gender",unique = true)
    private String personGender;
    @Column(name = "person_age",unique = true)
    private int personAge;
    @Column(name = "person_identification",unique = true)
    private String personIdentification;
    @Column(name = "person_address",unique = true)
    private String personAddress;
    @Column(name = "person_phone",unique = true)
    private String personPhone;
}
