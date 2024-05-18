package com.microservice.account.services;

import com.microservice.account.entities.Account;
import com.microservice.account.repositories.AccountRepository;
import com.microservice.account.repositories.base.BaseRepository;
import com.microservice.account.services.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends BaseServiceImpl<Account, Long> {
    @Autowired
    public AccountRepository accountRepository;

    public AccountService(BaseRepository<Account, Long> baseRepository) {
        super(baseRepository);
    }
}
