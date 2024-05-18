package com.microservice.customer.services;

import com.microservice.customer.entities.Customer;
import com.microservice.customer.repositories.base.BaseRepository;
import com.microservice.customer.repositories.CustomerRepository;
import com.microservice.customer.services.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseServiceImpl<Customer, Long> {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(BaseRepository<Customer, Long> baseRepository) {
        super(baseRepository);
    }
}
