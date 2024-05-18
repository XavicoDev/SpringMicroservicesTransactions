package com.microservice.customer.repositories;

import com.microservice.customer.dto.projections.CustomerPrj;
import com.microservice.customer.entities.Customer;
import com.microservice.customer.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends BaseRepository<Customer, Long> {
    CustomerPrj findAllProjectedByPersonIdentification(String identification);
}
