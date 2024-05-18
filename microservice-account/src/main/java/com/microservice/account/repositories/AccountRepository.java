package com.microservice.account.repositories;

import com.microservice.account.dto.projections.MovementPrj;
import com.microservice.account.entities.Account;
import com.microservice.account.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends BaseRepository<Account, Long> {
    Account findByAccountNumber(String accountId);
}
