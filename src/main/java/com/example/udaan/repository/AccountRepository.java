package com.example.udaan.repository;

import com.example.udaan.dto.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
