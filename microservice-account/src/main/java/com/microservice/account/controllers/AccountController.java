package com.microservice.account.controllers;

import com.microservice.account.clients.CustomersClient;
import com.microservice.account.controllers.base.BaseControllerImpl;
import com.microservice.account.dto.CustomersDTO;
import com.microservice.account.entities.Account;
import com.microservice.account.repositories.AccountRepository;
import com.microservice.account.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/cuentas")
public class AccountController extends BaseControllerImpl<Account, AccountService> {

    @Autowired
    private AccountService accountService;


    @PostMapping("/crear/validando")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> save(@RequestBody Account entity) {
        try {
            boolean registered=accountService.saveValidation(entity);
            if (registered) {
                return new ResponseEntity<>("Registro exitoso", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("El cliente asociado no existe", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Registro fallido: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
