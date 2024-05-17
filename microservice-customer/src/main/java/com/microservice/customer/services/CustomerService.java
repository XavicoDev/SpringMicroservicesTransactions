package com.microservice.customer.services;

import com.microservice.customer.entities.Customer;
import com.microservice.customer.repositories.BaseRepository;
import com.microservice.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseServiceImpl<Customer, Long>{
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(BaseRepository<Customer, Long> baseRepository) {
        super(baseRepository);
    }
}
