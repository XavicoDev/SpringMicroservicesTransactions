package com.microservice.account.controllers;

import com.microservice.account.controllers.base.BaseControllerImpl;
import com.microservice.account.entities.Account;
import com.microservice.account.entities.Movement;
import com.microservice.account.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/movimientos")
public class MovementController extends BaseControllerImpl<Movement, MovementService> {

    @Autowired
    private MovementService movementService;
    @PostMapping("/crear/validando")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> save(@RequestBody Movement entity) {
        try {
            Double movementValue = entity.getMovementValue();
            boolean isZeroOrNull = movementValue == null || movementValue.equals(0.0);
            if (!isZeroOrNull) {
                movementService.save(entity);
                return new ResponseEntity<>("Registro exitoso", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("El valor del movimiento no es valido", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Registro fallido: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
