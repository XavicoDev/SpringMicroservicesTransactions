package com.microservice.account.services;

import com.microservice.account.clients.CustomersClient;
import com.microservice.account.dto.CustomersDTO;
import com.microservice.account.entities.Account;
import com.microservice.account.repositories.AccountRepository;
import com.microservice.account.repositories.base.BaseRepository;
import com.microservice.account.services.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AccountService extends BaseServiceImpl<Account, Long> {
    @Autowired
    public AccountRepository accountRepository;

    @Autowired
    private CustomersClient customersClient;

    public AccountService(BaseRepository<Account, Long> baseRepository) {
        super(baseRepository);
    }


    public boolean saveValidation(@RequestBody Account entity) {
        try {
            if (customersClient.getExist(entity.getCustomerId())) {
                accountRepository.save(entity);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
