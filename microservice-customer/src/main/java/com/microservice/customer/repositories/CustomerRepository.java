package com.microservice.customer.repositories;

import com.microservice.customer.entities.Customer;
import com.microservice.customer.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends BaseRepository<Customer, Long> {
}
