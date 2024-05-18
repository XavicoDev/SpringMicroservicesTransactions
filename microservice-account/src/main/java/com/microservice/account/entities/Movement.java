package com.microservice.account.entities;

import com.microservice.account.dto.Base;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movement")
public class Movement extends Base {
    @Column(name = "movement_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date movementDate;

    @Column(name = "movement_type", nullable = false)
    private String movementType;

    @Column(name = "movement_value", nullable = false)
    private Double movementValue;

    @Column(name = "movement_balance", nullable = false)
    private Double movementBalance;
}
