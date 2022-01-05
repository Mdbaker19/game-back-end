package com.example.apiside.repository;

import com.example.apiside.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountByAccountName(String name);
}
