package com.microservice.account.repositories;

import com.microservice.account.entities.Account;
import com.microservice.account.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends BaseRepository<Account, Long> {
}
