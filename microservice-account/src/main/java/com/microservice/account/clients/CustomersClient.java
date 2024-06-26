package com.microservice.account.clients;

import com.microservice.account.dto.CustomersDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-customer", url = "localhost:8091/api/v1/clientes", primary = false)
public interface CustomersClient {

    @GetMapping("/existe/{id}")
    boolean getExist(@PathVariable Long id);

    @GetMapping("/proyectada/{id}")
    CustomersDTO getOnePrj(@PathVariable String id);
}