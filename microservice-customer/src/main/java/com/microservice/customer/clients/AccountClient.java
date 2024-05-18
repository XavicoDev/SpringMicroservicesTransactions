package com.microservice.customer.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-account", url = "localhost:8092/api/v1/cuentas")
public interface AccountClient {

    @GetMapping("/search/{id}")
    List<?> getOne(@PathVariable Long accountId);
}
