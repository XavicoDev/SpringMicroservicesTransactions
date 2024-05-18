package com.microservice.account.clients;

import com.microservice.account.dto.CustomersDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-customer", url = "localhost:8090/api/v1/clientes", primary = false)
public interface CustomersClient {

    @GetMapping("/existe/{id}")
    boolean getExist(@PathVariable Long id);
}