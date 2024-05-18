package com.microservice.customer.controllers;

import com.microservice.customer.controllers.base.BaseControllerImpl;
import com.microservice.customer.dto.projections.CustomerPrj;
import com.microservice.customer.entities.Customer;
import com.microservice.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/clientes")
public class CustomerController extends BaseControllerImpl<Customer, CustomerService> {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/proyectada/{identification}")
    public ResponseEntity<CustomerPrj> getAllMovementsProjected(@PathVariable String identification) {
        try {
            CustomerPrj accountMovementDTO= customerService.findAllProjectedByPersonIdentification(identification);
            return new ResponseEntity<>(accountMovementDTO, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
