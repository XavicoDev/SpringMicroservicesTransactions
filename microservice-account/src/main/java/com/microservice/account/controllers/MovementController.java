package com.microservice.account.controllers;

import com.microservice.account.controllers.base.BaseControllerImpl;
import com.microservice.account.entities.Movement;
import com.microservice.account.services.MovementService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/movimientos")
public class MovementController extends BaseControllerImpl<Movement, MovementService> {
}
