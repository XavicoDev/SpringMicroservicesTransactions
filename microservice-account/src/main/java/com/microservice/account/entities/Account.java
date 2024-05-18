package com.microservice.account.entities;

import com.microservice.account.dto.Base;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account extends Base {

    @Column(name = "customer_id", nullable = false)
    private Long customerId;
    @Column(name = "account_number",unique = true,nullable = false)
    private String accountNumber;
    @Column(name = "account_type",nullable = false)
    private String accountType;
    @Column(name = "account_initial_balance", nullable = false)
    private Double accountInitialBalance;
    @Column(name = "account_status", nullable = false)
    private Boolean accountStatus;
}
