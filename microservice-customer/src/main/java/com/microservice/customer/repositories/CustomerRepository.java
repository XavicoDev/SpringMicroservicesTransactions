package com.microservice.customer.repositories;

import com.microservice.customer.entities.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends BaseRepository<Customer, Long> {
}
