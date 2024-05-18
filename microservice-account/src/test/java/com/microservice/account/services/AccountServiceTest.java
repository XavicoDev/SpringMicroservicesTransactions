package com.microservice.account.services;

import com.microservice.account.entities.Account;
import com.microservice.account.repositories.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAllByCustomerId() {
        
        Long customerId = 123L;
        List<Account> mockAccounts = new ArrayList<>();
        mockAccounts.add(new Account(customerId, "123456", "Checking", 1000.0, true));
        mockAccounts.add(new Account(customerId, "789012", "Savings", 2000.0, true));

        when(accountRepository.findAllByCustomerId(customerId)).thenReturn(mockAccounts);

        List<Account> returnedAccounts = accountService.findAllByCustomerId(customerId);

        Assertions.assertEquals(mockAccounts.size(), returnedAccounts.size());
        Assertions.assertEquals(mockAccounts.get(0), returnedAccounts.get(0));
        Assertions.assertEquals(mockAccounts.get(1), returnedAccounts.get(1));
    }
}