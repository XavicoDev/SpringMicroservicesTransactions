package com.microservice.customer.entities;

import com.microservice.customer.dto.Base;
import com.microservice.customer.dto.Person;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer  extends Person {
    @Column(name = "customer_password",unique = true,nullable = false)
    private String customerPassword;
    @Column(name = "customer_status",unique = true,nullable = false)
    private String customerStatus;
}
