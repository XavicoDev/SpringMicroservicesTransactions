package com.microservice.account.controllers;

import com.microservice.account.controllers.base.BaseControllerImpl;
import com.microservice.account.entities.Account;
import com.microservice.account.services.AccountService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/cuentas")
public class AccountController extends BaseControllerImpl<Account, AccountService> {
}
