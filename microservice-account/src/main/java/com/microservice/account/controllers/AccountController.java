package com.microservice.account.controllers;

import com.microservice.account.clients.CustomersClient;
import com.microservice.account.controllers.base.BaseControllerImpl;
import com.microservice.account.dto.AccountMovementDTO;
import com.microservice.account.dto.CustomersDTO;
import com.microservice.account.dto.MovementDetailDTO;
import com.microservice.account.dto.projections.MovementPrj;
import com.microservice.account.entities.Account;
import com.microservice.account.repositories.AccountRepository;
import com.microservice.account.services.AccountService;
import com.microservice.account.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/cuentas")
public class AccountController extends BaseControllerImpl<Account, AccountService> {

    @Autowired
    private AccountService accountService;
    @Autowired
    private MovementService movementService;

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

    @GetMapping("/reporte")
    public ResponseEntity<?> generateStateAccountReport(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date minData,
                                                        @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date maxData,
                                                        @RequestParam Long accountId){
        try {
            AccountMovementDTO accountMovementDTO= new AccountMovementDTO();
            Account account= accountService.finById(accountId);
            if(account!=null){
                List<MovementPrj> projectedMovements =
                        movementService.findAllProjectedByAccountIdAndMovementDateBetween(accountId,minData,maxData);
                accountMovementDTO.setAccountNumber(account.getAccountNumber());
                accountMovementDTO.setAccountBalance(account.getAccountInitialBalance());
                accountMovementDTO.setMovementList(projectedMovements);
                return new ResponseEntity<>(accountMovementDTO, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(accountMovementDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
