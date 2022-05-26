package com.example.udaan.service;

import com.example.udaan.dto.Account;
import com.example.udaan.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Optional<Account> getAccountById(Long accountId) {
        return  accountRepository.findById(accountId);
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }
}
