package com.microservice.customer.controller;

import com.microservice.customer.entities.Customer;
import com.microservice.customer.services.CustomerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/customer")
public class CustomerController extends BaseControllerImpl<Customer, CustomerService>{
}
