package com.microservice.account.controllers;

import com.microservice.account.controllers.base.BaseControllerImpl;
import com.microservice.account.dto.MovementDTO;
import com.microservice.account.dto.projections.MovementPrj;
import com.microservice.account.entities.Account;
import com.microservice.account.entities.Movement;
import com.microservice.account.services.AccountService;
import com.microservice.account.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/movimientos")
public class MovementController extends BaseControllerImpl<Movement, MovementService> {

    @Autowired
    private MovementService movementService;
    @Autowired
    private AccountService accountService;
    @PostMapping("/crear/validando")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public ResponseEntity<?> save(@RequestBody MovementDTO entity) {
        try {
            Movement entityNew= new Movement();
            entityNew.setMovementDate(entity.getMovementDate());
            entityNew.setMovementValue(entity.getMovementValue());
            Double movementValue = entity.getMovementValue();
            Account account = null;
            try {
                 account = accountService.findByAccountNumber(entity.getAccountNumber());
                if(account!=null){
                    entityNew.setAccount(account);
                    boolean isZeroOrNull = movementValue == null || movementValue.equals(0.0);
                    if (!isZeroOrNull) {
                        Double finalBalance =account.getAccountInitialBalance();
                        if (movementValue > 0) {
                            entityNew.setMovementType("Desposito");
                            finalBalance+=entity.getMovementValue();
                        } else {
                            entityNew.setMovementType("Retiro");
                            finalBalance+=entity.getMovementValue();
                            if(finalBalance<0){
                                return new ResponseEntity<>("Su saldo actual no permite el retiro, usted cuenta con $"+account.getAccountInitialBalance(), HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                        }
                        account.setAccountInitialBalance(finalBalance);
                        entityNew.setMovementBalance(finalBalance);
                        movementService.save(entityNew);
                        accountService.update(account.getId(),account);
                        return new ResponseEntity<>("Registro exitoso", HttpStatus.CREATED);
                    } else {
                        return new ResponseEntity<>("El valor del movimiento no es valido", HttpStatus.BAD_REQUEST);
                    }
                }
                else {
                    return new ResponseEntity<>("No se pudo identificar la cuenta", HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } catch (Exception e) {
                return new ResponseEntity<>("Hubo problemas al identificar la cuenta", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Registro fallido: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/consulta/proyectada")
    public ResponseEntity<List<MovementPrj>> getAllMovementsProjected() {
        List<MovementPrj> projectedMovements = movementService.findAllProjectedBy();
        return new ResponseEntity<>(projectedMovements, HttpStatus.OK);
    }
}
