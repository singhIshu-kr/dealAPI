package com.example.udaan.controller;

import com.example.udaan.dto.Account;
import com.example.udaan.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/account")
@CrossOrigin
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountQueryService) {
        this.accountService = accountQueryService;
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable(value = "accountId") Long accountId) {
        Optional<Account> accountOpt = accountService.getAccountById(accountId);
        return accountOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/list")
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

}
